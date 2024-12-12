package com.group9.partypulse.provider;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProviderRepo extends JpaRepository<Provider, Integer> {
    Optional<Provider> findByEmail(String email); // Added to support login
}

