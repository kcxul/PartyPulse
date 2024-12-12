package com.group9.partypulse.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepo providerRepo;

    public List<Provider> getAllProviders() {
        return providerRepo.findAll();
    }

    public Provider findProviderByID(int provider_id) {
        Optional<Provider> provider = providerRepo.findById(provider_id);
        return provider.orElse(null);
    }

    public void addNewProvider(Provider provider) {
        providerRepo.save(provider);
    }

    public void editProvider(int provider_id, Provider provider) {
        Provider existing = findProviderByID(provider_id);
        if (existing != null) {
            existing.setProviderName(provider.getProviderName());
            existing.setEmail(provider.getEmail());
            existing.setDescription(provider.getDescription());
            providerRepo.save(existing);
        }
    }

    public void deleteProviderByID(int provider_id) {
        providerRepo.deleteById(provider_id);
    }

    public Provider authenticateProvider(String email, String password) {
        Provider provider = providerRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        if (!provider.getPassword().equals(password)) {
            throw new RuntimeException("Invalid credentials");
        }

        return provider;
    }
}
