package com.group9.partypulse.PartySpace;

import com.group9.partypulse.PartySpace.PartySpace;
import com.group9.partypulse.PartySpace.PartySpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/party-space")  // General base path for PartySpace endpoints
public class PartySpaceController {

    @Autowired
    private PartySpaceService service;

    // Redirect to index page
    @GetMapping("/")
    public String home() {
        return "redirect:/index.html";
    }

    // Redirect to login page
    @GetMapping("/login")
    public String login() {
        return "redirect:/login.html";
    }

    // Redirect to signup page
    @GetMapping("/register")
    public String register() {
        return "redirect:/signup.html";
    }

    // API to get all party spaces (for JSON responses, if needed)
    @ResponseBody
    @GetMapping("/all")
    public List<PartySpace> getAllPartySpaces() {
        return service.getAllPartySpaces();
    }

    // Get party space by ID
    @ResponseBody
    @GetMapping("/{partySpace_id}")
    public PartySpace findPartySpaceByID(@PathVariable int partySpace_id) {
        return service.findPartySpaceByID(partySpace_id);
    }

    // Edit party space
    @GetMapping("/edit/{partySpace_id}")
    public String editPartySpace(@PathVariable int partySpace_id, Model model) {
        model.addAttribute("partySpace", service.findPartySpaceByID(partySpace_id));
        return "partyspace-settings";
    }

    // Update party space
    @PostMapping("/update/{partySpace_id}")
    public String updatePartySpace(@PathVariable int partySpace_id, @ModelAttribute PartySpace partySpace) {
        // Ensure that the party space has the correct ID before updating
        partySpace.setPartySpaceId(partySpace_id);
        service.addNewPartySpace(partySpace);
        return "redirect:/party-space/" + partySpace.getPartySpaceId();  // Redirect to updated party space page
    }

    // Add new party space
    @ResponseBody
    @PostMapping("/new")
    public String addNewPartySpace(@ModelAttribute PartySpace partySpace) {
        service.addNewPartySpace(partySpace);
        return "redirect:/party-space/" + partySpace.getPartySpaceId();  // Redirect to the newly created party space
    }

    // Manage all party spaces
    @GetMapping("/manage")
    public String managePartySpaces(Model model) {
        List<PartySpace> partySpaces = service.getAllPartySpaces();
        model.addAttribute("partySpaces", partySpaces);
        return "managePartySpaces";
    }

    // Delete party space
    @GetMapping("/delete/{partySpace_id}")  // Make sure to not repeat the same variable in path
    public String deletePartySpace(@PathVariable int partySpace_id) {
        service.deletePartySpaceByID(partySpace_id);
        return "redirect:/party-space/manage";  // Redirect to manage page after deletion
    }
}
