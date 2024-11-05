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

    @GetMapping("/{servid}")
    public String PartySpace(){
        model.addAttribute("partyPulse", service.findPartyPulseByID(servid));
        model.addAttribute("title", servid);
        return "redirect:/partyspace.html";}


}