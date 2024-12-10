package com.group9.partypulse.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/PartyPulse/provider")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @GetMapping("/")
    public String home() {
        return "redirect:/index.html";
    }

    @ResponseBody
    @GetMapping("/all/providers")
    public List<Provider> getAllProviders() {
        return providerService.getAllProviders();
    }

    @ResponseBody
    @GetMapping("/provider/{provider_id}")
    public Provider findProviderByID(@PathVariable int provider_id) {
        return providerService.findProviderByID(provider_id);
    }

    @ResponseBody
    @PostMapping("/new/provider")
    public List<Provider> addNewProvider(@RequestBody Provider provider) {
        providerService.addNewProvider(provider);
        return providerService.getAllProviders();
    }

    @ResponseBody
    @PutMapping("/edit/{provider_id}")
    public Provider editProvider(@PathVariable int provider_id, @RequestBody Provider provider) {
        providerService.editProvider(provider_id, provider);
        return providerService.findProviderByID(provider_id);
    }

    @GetMapping("/delete/{provider_id}")
    public String deleteProvider(@PathVariable int provider_id) {
        providerService.deleteProviderByID(provider_id);
        return "redirect:/PartyPulse/provider/manage";
    }

    @GetMapping("/manage")
    public String manageProviders(Model model) {
        List<Provider> providers = providerService.getAllProviders();
        model.addAttribute("providers", providers);
        return "manageProviders";
    }
}
