package com.group9.partypulse.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/User")
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

    //user stuff here

    @GetMapping("/all/users")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/user/{user_id}")
    public User findUserByID(@PathVariable int user_id) {
        return service.findUserByID(user_id);
    }

    @GetMapping("/edit/{user_id}")
    public String editUser(@PathVariable int user_id, Model model) {
        model.addAttribute("user", service.findUserByID(user_id));
        return "editprofile";
    }

    @PostMapping("/update-profile")
    public String updateUser(User user){
        service.addNewUser(user);
        return "redirect:/PartyPulse/partyspace";
    }

    @PostMapping("/new/user")
    public String addNewUser(User user) {
        service.addNewUser(user);
        return "redirect:/partyspacelist";
    }

    @DeleteMapping("/delete/{user_id}")
    public List<User> deleteUserByID(@PathVariable int user_id) {
        service.deleteUserByID(user_id);
        return service.getAllUsers();
    }
}