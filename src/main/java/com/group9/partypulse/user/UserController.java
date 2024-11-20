package com.group9.partypulse.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller  // Updated to @Controller to support view rendering
@RequestMapping("/PartyPulse/userview")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public String home() {
        return "redirect:/index.html";
    }

    @GetMapping("/login")
    public String login() {
        return "redirect:/login.html";
    }

    @GetMapping("/register")
    public String register() {
        return "redirect:/signup.html";
    }

    // API to get all users (for JSON responses, if needed)
    @ResponseBody
    @GetMapping("/all/users")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    // API to find a user by ID (for JSON responses, if needed)
    @ResponseBody
    @GetMapping("/user/{user_id}")
    public User findUserByID(@PathVariable int user_id) {
        return service.findUserByID(user_id);
    }

    // API to edit a user by ID (for JSON responses, if needed)
    @ResponseBody
    @PutMapping("/edit/{user_id}")
    public User editUser(@PathVariable int user_id, @RequestBody User user) {
        service.editUser(user_id, user);
        return service.findUserByID(user_id);
    }

    // API to add a new user (for JSON responses, if needed)
    @ResponseBody
    @PostMapping("/new/user")
    public List<User> addNewUser(@RequestBody User user) {
        service.addNewUser(user);
        return service.getAllUsers();
    }

    // HTML-based user management page
    @GetMapping("/manage")
    public String manageUsers(Model model) {
        List<User> users = service.getAllUsers();
        model.addAttribute("users", users); // Pass user list to the template
        return "manageUsers"; // Render the "manageUsers.html" template
    }

    // HTML-based user deletion
    @GetMapping("/delete/{user_id}")
    public String deleteUser(@PathVariable int user_id) {
        service.deleteUserByID(user_id);
        return "redirect:/PartyPulse/userview/manage"; // Redirect back to the management page
    }
}