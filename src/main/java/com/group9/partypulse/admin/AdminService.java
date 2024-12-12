package com.group9.partypulse.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;  // Import the BCryptPasswordEncoder
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;  // Inject the BCryptPasswordEncoder for hashing passwords

    // Get all admins
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    // Find admin by id
    public Optional<Admin> findAdminById(Long id) {
        return adminRepository.findById(id);
    }

    // Find admin by username
    public Admin findAdminByUsername(String username) {
        return adminRepository.findByUsername(username).orElse(null);  // Return null if not found
    }

    // Get active admins
    public List<Admin> getActiveAdmins() {
        return adminRepository.findByAccountStatus("Active");
    }

    // Get suspended admins
    public List<Admin> getSuspendedAdmins() {
        return adminRepository.findByAccountStatus("Suspended");
    }

    // Create a new admin with password hashing
    public Admin createAdmin(Admin admin) {
        // Check if admin already exists by username
        if (findAdminByUsername(admin.getUsername()) != null) {
            // Return null or throw exception if admin already exists
            return null; // or throw new RuntimeException("Admin already exists");
        }

        // Hash the password before saving
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));

        // Set the default account status (e.g., "Active")
        if (admin.getAccountStatus() == null) {
            admin.setAccountStatus("Active");
        }

        return adminRepository.save(admin);  // Save the admin
    }

    // Update an existing admin with password hashing
    public Admin updateAdmin(Long id, Admin updatedAdmin) {
        Optional<Admin> existingAdmin = adminRepository.findById(id);

        if (existingAdmin.isPresent()) {
            Admin admin = existingAdmin.get();

            // Update username
            admin.setUsername(updatedAdmin.getUsername());

            // Only hash the password if it is being updated
            if (!updatedAdmin.getPassword().equals(admin.getPassword())) {
                admin.setPassword(passwordEncoder.encode(updatedAdmin.getPassword()));  // Hash the new password
            }

            // Update account status
            admin.setAccountStatus(updatedAdmin.getAccountStatus());

            return adminRepository.save(admin);  // Save the updated admin
        }

        return null;  // Return null if the admin was not found
    }

    // Delete an admin
    public void deleteAdmin(Long id) {
        // Check if admin exists before deleting
        if (adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
        } else {
            // Optionally throw exception if admin doesn't exist
            throw new RuntimeException("Admin not found");
        }
    }
}
