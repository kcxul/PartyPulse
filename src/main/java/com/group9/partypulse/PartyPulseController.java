package com.group9.partypulse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
@Controller
@RequestMapping("/PartyPulse")
public class PartyPulseController {

    @Autowired
    private PartyService service;

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

    @GetMapping("/{user_id}")
    public String editUser(@PathVariable int user_id, Model model){
        model.addAttribute("user", service.findUserByID(user_id));
        return "editprofile";
    }

    @GetMapping("/{party_id}")
    public String PartySpace(){
        model.addAttribute("partyPulse", service.findPartyPulseByID(party_id));
        model.addAttribute("title", party_id);
        return "redirect:/partyspace.html";}


}