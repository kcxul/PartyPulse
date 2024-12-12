package com.group9.partypulse.PartySpace;

import com.group9.partypulse.PartySpace.PartySpace;
import com.group9.partypulse.PartySpace.PartySpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller  // Updated to @Controller to support view rendering
@RequestMapping("/{PartySpace_id}")
public class PartySpaceController {

    @Autowired
    private PartySpaceService service;

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
    @GetMapping("/all/PartySpaces")
    public List<PartySpace> getAllPartySpaces() {
        return service.getAllPartySpaces();
    }


    @ResponseBody
    @GetMapping("/PartySpace/{user_id}")
    public PartySpace findPartySpaceByID(@PathVariable int PartySpace_id) {
        return service.findPartySpaceByID(PartySpace_id);
    }



    @GetMapping("/edit/{PartySpace_id}")
    public String editPartySpace(@PathVariable int PartySpace_id, Model model) {
        model.addAttribute("PartySpace", service.findPartySpaceByID(PartySpace_id));
        return "partyspace-settings";
    }

    @PostMapping("/update-PartySpace")
    public String updateUser(User user){
        service.addNewUser(user);
        return "redirect:/PartyPulse/{PartySpace_id}";
    }


    @ResponseBody
    @PostMapping("/new/PartySpace")
    public String addNewPartySpace(PartySpace partySpace) {
        service.addNewPartySpace(partySpace);
        return "redirect:/PartyPulse/{PartySpace_id}";
    }

    // HTML-based user management page
    @GetMapping("/manage")
    public String managePartySpace(Model model) {
        List<PartySpace> partySpace = service.getAllPartySpaces();
        model.addAttribute("PartySpace", partySpace);
        return "managePartySpaces";
    }

    // HTML-based user deletion
    @GetMapping("/delete/{PartySpace_id}")
    public String deletePartySpace(@PathVariable int PartySpace_id) {
        service.deletePartySpaceByID(PartySpace_id);
        return "redirect:/PartyPulse/userview/manage"; // Redirect back to the management page
    }
}