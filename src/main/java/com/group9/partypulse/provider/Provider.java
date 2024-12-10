package com.group9.partypulse.provider;

import jakarta.persistence.*;

@Entity
@Table(name = "providers")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int provider_id;

    @Column(nullable = false)
    private String providerName;

    @Column(nullable = false)
    private String email;

    private String description;

    public Provider() {
    }

    public Provider(String providerName, String email, String description) {
        this.providerName = providerName;
        this.email = email;
        this.description = description;
    }

    public int getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(int provider_id) {
        this.provider_id = provider_id;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
