package com.group9.partypulse.admin;

import com.group9.partypulse.user.UserService;
import com.group9.partypulse.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder; // Inject BCryptPasswordEncoder

    // Show the login page (admin login form)
    @GetMapping("/login")
    public String showLoginPage() {
        return "AdminLogin";  // Updated to match the template name exactly
    }

    // Handle login functionality (hardcoded credentials check)
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // Hardcoded credentials for testing
        String correctUsername = "admin";
        String correctPassword = "password123";

        // Check if the provided username and password match the hardcoded values
        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            // Login successful
            return "redirect:/admin/dashboard";  // Redirect to the admin dashboard
        } else {
            // Incorrect credentials
            model.addAttribute("error", "Invalid username or password");
            return "AdminLogin";  // Updated to match the template name exactly
        }
    }

    // Show the admin dashboard
    @GetMapping("/dashboard")
    public String showAdminDashboard(Model model) {
        long totalAdmins = adminService.getAllAdmins().size();
        long activeAdmins = adminService.getActiveAdmins().size();
        long suspendedAdmins = adminService.getSuspendedAdmins().size();

        model.addAttribute("totalAdmins", totalAdmins);
        model.addAttribute("activeAdmins", activeAdmins);
        model.addAttribute("suspendedAdmins", suspendedAdmins);

        return "adminDashboard"; // Ensure the template name matches the actual template in resources/templates
    }

    // Show form to create a new admin
    @GetMapping("/form")
    public String showCreateAdminForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "adminForm";  // Ensure the template name matches the actual template
    }

    // Handle form submission for creating a new admin
    @PostMapping("/form")
    public String createAdmin(@ModelAttribute Admin admin) {
        // Hash the password before saving it
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminRepository.save(admin);
        return "redirect:/admin/all";  // Redirect to the admin list page
    }

    // Show form to edit an existing admin
    @GetMapping("/edit/{id}")
    public String showEditAdminForm(@PathVariable Long id, Model model) {
        Optional<Admin> admin = adminService.findAdminById(id);
        if (admin.isPresent()) {
            model.addAttribute("admin", admin.get());
            return "adminForm";  // Ensure the template name matches the actual template
        }
        return "redirect:/admin/all";  // Redirect if admin not found
    }

    // Handle form submission for updating admin
    @PostMapping("/update/{id}")
    public String updateAdmin(@PathVariable Long id, @ModelAttribute Admin updatedAdmin) {
        // If the password is updated, hash it again before saving
        if (updatedAdmin.getPassword() != null && !updatedAdmin.getPassword().isEmpty()) {
            updatedAdmin.setPassword(passwordEncoder.encode(updatedAdmin.getPassword()));
        }
        adminService.updateAdmin(id, updatedAdmin);
        return "redirect:/admin/all";  // Redirect to the admin list page
    }

    // View admin details
    @GetMapping("/view/{id}")
    public String viewAdminDetails(@PathVariable Long id, Model model) {
        Optional<Admin> admin = adminService.findAdminById(id);
        if (admin.isPresent()) {
            model.addAttribute("admin", admin.get());
            return "adminDetail";  // Ensure the template name matches the actual template
        }
        return "redirect:/admin/all";  // Redirect to all admins list
    }

    // Delete admin
    @GetMapping("/delete/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return "redirect:/admin/all";  // Redirect to the admin list page
    }

    // Show all users (admin view)
    @GetMapping("/users/all")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "adminUserList";  // Ensure the template name matches the actual template
    }

    // Show form to manage users (admin view)
    @GetMapping("/users/manage")
    public String manageUsers(@RequestParam(value = "username", required = false) String username, Model model) {
        List<User> users;
        if (username != null && !username.isEmpty()) {
            users = userService.searchUsersByUsername(username);
        } else {
            users = userService.getAllUsers();
        }
        model.addAttribute("users", users);
        return "adminManageUsers";  // Ensure the template name matches the actual template
    }

    // Edit user form (for Admin to edit user)
    @GetMapping("/users/edit/{userId}")
    public String showEditUserForm(@PathVariable int userId, Model model) {
        User user = userService.findUserByID(userId);
        if (user != null) {
            model.addAttribute("user", user);
            return "adminEditUser";  // Ensure the template name matches the actual template
        }
        return "redirect:/admin/users/manage";  // Redirect if user not found
    }

    // Handle user update from admin
    @PostMapping("/users/update/{userId}")
    public String updateUser(@PathVariable int userId, @ModelAttribute User updatedUser) {
        userService.editUser(userId, updatedUser);
        return "redirect:/admin/users/manage";  // Redirect to manage users
    }

    // Toggle user status (activate/suspend)
    @PostMapping("/users/toggle-status/{userId}")
    public String toggleUserStatus(@PathVariable int userId) {
        User user = userService.findUserByID(userId);
        if (user != null) {
            String currentStatus = user.getAccountStatus();
            user.setAccountStatus(currentStatus.equals("Active") ? "Suspended" : "Active");
            userService.editUser(userId, user);
        }
        return "redirect:/admin/users/manage";  // Redirect to manage users
    }

    // Delete user by ID (admin action)
    @GetMapping("/users/delete/{userId}")
    public String deleteUser(@PathVariable int userId) {
        userService.deleteUserByID(userId);
        return "redirect:/admin/users/manage";  // Redirect to manage users
    }
}
