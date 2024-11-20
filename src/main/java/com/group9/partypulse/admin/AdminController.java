package com.group9.partypulse.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminRepository adminRepository;

    // Show all admins
    @GetMapping("/all")
    public String getAllAdmins(Model model) {
        List<Admin> admins = adminService.getAllAdmins();
        model.addAttribute("admins", admins);
        return "adminList";
    }

    // Show admin dashboard
    @GetMapping("/dashboard")
    public String showAdminDashboard(Model model) {
        long totalAdmins = adminService.getAllAdmins().size();
        long activeAdmins = adminService.getActiveAdmins().size();
        long suspendedAdmins = adminService.getSuspendedAdmins().size();

        model.addAttribute("totalAdmins", totalAdmins);
        model.addAttribute("activeAdmins", activeAdmins);
        model.addAttribute("suspendedAdmins", suspendedAdmins);

        return "adminDashboard";
    }

    // Show form to create a new admin
    @GetMapping("/form")
    public String showCreateAdminForm(Model model) {
        model.addAttribute("admin", new Admin());  // Create a new admin object
        return "adminForm";  // Create new admin form
    }

    // Handle form submission for creating a new admin
    @PostMapping("/form")
    public String createAdmin(@ModelAttribute Admin admin) {
        adminRepository.save(admin);  // Save the new admin
        return "redirect:/admin/all";  // Redirect back to admin list
    }

    // Show form to edit an existing admin
    @GetMapping("/edit/{id}")
    public String showEditAdminForm(@PathVariable Long id, Model model) {
        Optional<Admin> admin = adminService.findAdminById(id);
        if (admin.isPresent()) {
            model.addAttribute("admin", admin.get());
            return "adminForm";  // Edit admin form
        }
        return "redirect:/admin/all";  // Redirect if not found
    }

    // Handle form submission for updating admin
    @PostMapping("/update/{id}")
    public String updateAdmin(@PathVariable Long id, @ModelAttribute Admin updatedAdmin) {
        adminService.updateAdmin(id, updatedAdmin);
        return "redirect:/admin/all";
    }

    // View admin details
    @GetMapping("/view/{id}")
    public String viewAdminDetails(@PathVariable Long id, Model model) {
        Optional<Admin> admin = adminService.findAdminById(id);
        if (admin.isPresent()) {
            model.addAttribute("admin", admin.get());
            return "adminDetail";
        }
        return "redirect:/admin/all";
    }

    // Delete admin
    @GetMapping("/delete/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return "redirect:/admin/all";
    }
}