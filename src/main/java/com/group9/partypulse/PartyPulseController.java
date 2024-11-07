package com.group9.partypulse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
@RestController
@RequestMapping("/PartyPulse")
public class PartyPulseController {

    @Autowired
    private PartyPulseService service;

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
    public List<PartyPulse> getAllUsers() {return service.getAllUsers();}

    @GetMapping("/user/{user_id}")
    public PartyPulse findUserByID(@PathVariable int user_id){
        return service.findUserByID(user_id);
    }

    @PutMapping("/edit/{user_id}")
    public PartyPulse editUser(@PathVariable int user_id, @RequestBody PartyPulse user){
        service.editUser(user_id, user);
        return service.findUserByID(user_id);
    }

    @PostMapping("/new/user")
    public List<PartyPulse> addNewUser(@RequestBody PartyPulse user){
        service.addNewUser(user);
        return service.getAllUsers();
    }

    @DeleteMapping("/delete/{user_id}")
    public List<PartyPulse> deleteUserByID(@PathVariable int user_id){
        service.deleteUserByID(user_id);
        return service.getAllUsers();
    }

    //provider stuff here
    @GetMapping("/partyspace/{partyspace_id}")
    public PartyPulse findPartySpaceByID(@PathVariable int partyspace_id) {
        return service.findPartySpaceByID(partyspace_id);
    }

    @PostMapping("/new/partyspace")
    public void addNewPartySpace(@RequestBody PartyPulse partySpace) {
        service.addNewPartySpace(partySpace);
    }

	@DeleteMapping("/delete/{partyspace_id}")
    public void deletePartySpaceByID(@PathVariable int partyspace_id) {
        service.deletePartySpaceByID(partyspace_id);
    }




    //admin here
}