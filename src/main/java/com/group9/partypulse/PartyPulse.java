package com.group9.partypulse;

import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;

@Entity
@Table(name = "PartyPulse")
public class PartyPulse {

    // User fields (existing)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    private String profile_info;

    // Admin fields
    @Column(nullable = false)
    private boolean isAdmin; // Flag to determine if user is an admin

    @Column(nullable = false)
    private String adminRole; // Role of the admin, e.g., "Super Admin", "Content Moderator"

    @Column
    private String adminPrivileges; // Specific privileges for the admin (e.g., manage users, moderate content)

    // Provider fields (existing)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int partyspace_id;

    @Column(nullable = false)
    private String party_name;

    @Column(nullable = false)
    private String party_description;

    private String partyspace_icon;

    private String partyspace_banner;

    @Column(nullable = false)
    private String partyspace_privacy;

    // Constructors for User and Admin
    public PartyPulse(int user_id, String userName, String password, String profile_info, boolean isAdmin, String adminRole, String adminPrivileges) {
        this.user_id = user_id;
        this.userName = userName;
        this.password = password;
        this.profile_info = profile_info;
        this.isAdmin = isAdmin;
        this.adminRole = adminRole;
        this.adminPrivileges = adminPrivileges;
    }

    public PartyPulse(String userName, String password, String profile_info, boolean isAdmin, String adminRole, String adminPrivileges) {
        this.userName = userName;
        this.password = password;
        this.profile_info = profile_info;
        this.isAdmin = isAdmin;
        this.adminRole = adminRole;
        this.adminPrivileges = adminPrivileges;
    }

    public PartyPulse(String party_name, String party_description, String partyspace_icon, String partyspace_banner, String partyspace_privacy) {
        this.party_name = party_name;
        this.party_description = party_description;
        this.partyspace_icon = partyspace_icon;
        this.partyspace_banner = partyspace_banner;
        this.partyspace_privacy = partyspace_privacy;
    }

    public PartyPulse() {}

    // Getters and Setters for User fields
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfile_info() {
        return profile_info;
    }

    public void setProfile_info(String profile_info) {
        this.profile_info = profile_info;
    }

    // Admin-specific methods
    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(String adminRole) {
        this.adminRole = adminRole;
    }

    public String getAdminPrivileges() {
        return adminPrivileges;
    }

    public void setAdminPrivileges(String adminPrivileges) {
        this.adminPrivileges = adminPrivileges;
    }

    // Getters and Setters for Party fields
    public int getParty_id() {
        return partyspace_id;
    }

    public void setParty_id(int party_id) {
        this.partyspace_id = party_id;
    }

    public String getParty_name() {
        return party_name;
    }

    public void setParty_name(String party_name) {
        this.party_name = party_name;
    }

    public String getParty_description() {
        return party_description;
    }

    public void setParty_description(String party_description) {
        this.party_description = party_description;
    }

    public String getPartyspace_icon() {
        return partyspace_icon;
    }

    public void setPartyspace_icon(String partyspace_icon) {
        this.partyspace_icon = partyspace_icon;
    }

    public String getPartyspace_banner() {
        return partyspace_banner;
    }

    public void setPartyspace_banner(String partyspace_banner) {
        this.partyspace_banner = partyspace_banner;
    }

    public String getPartyspace_privacy() {
        return partyspace_privacy;
    }

    public void setPartyspace_privacy(String partyspace_privacy) {
        this.partyspace_privacy = partyspace_privacy;
    }
}