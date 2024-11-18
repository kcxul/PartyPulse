package com.group9.partypulse.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // Get all admins
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    // Find an admin by ID
    public Optional<Admin> findAdminById(Long id) {
        return adminRepository.findById(id);
    }

    // Find admin by username
    public Admin findAdminByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    // Create a new admin
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    // Update admin
    public Admin updateAdmin(Long id, Admin updatedAdmin) {
        Optional<Admin> existingAdmin = adminRepository.findById(id);
        if (existingAdmin.isPresent()) {
            Admin admin = existingAdmin.get();
            admin.setUsername(updatedAdmin.getUsername());
            admin.setPassword(updatedAdmin.getPassword());
            admin.setAccountStatus(updatedAdmin.getAccountStatus());
            return adminRepository.save(admin);
        }
        return null;
    }

    // Delete admin by ID
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
