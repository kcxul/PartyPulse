package com.group9.partypulse.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Get all admins
    @GetMapping("/all")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    // Get an admin by ID
    @GetMapping("/{id}")
    public Optional<Admin> getAdminById(@PathVariable Long id) {
        return adminService.findAdminById(id);
    }

    // Get an admin by username
    @GetMapping("/username/{username}")
    public Admin getAdminByUsername(@PathVariable String username) {
        return adminService.findAdminByUsername(username);
    }

    // Create a new admin
    @PostMapping("/new")
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.createAdmin(admin);
    }

    // Update an existing admin
    @PutMapping("/update/{id}")
    public Admin updateAdmin(@PathVariable Long id, @RequestBody Admin updatedAdmin) {
        return adminService.updateAdmin(id, updatedAdmin);
    }

    // Delete an admin by ID
    @DeleteMapping("/delete/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
    }
}