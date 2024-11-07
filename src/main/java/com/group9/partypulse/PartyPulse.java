package com.group9.partypulse;

import jakarta.persistence.*;

@Entity
public class PartyPulse {

    //user stuff here
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    private String profile_info;

    public PartyPulse(int user_id, String userName, String password, String profile_info){
        this.user_id = user_id;
        this.userName = userName;
        this.password = password;
        this.profile_info = profile_info;
    }
    public PartyPulse(String userName, String password, String profile_info){
        this.userName = userName;
        this.password = password;
        this.profile_info = profile_info;
    }
    public PartyPulse(){}

    public int getUser_id(){
        return user_id;
    }
    public void setUser_id(int user_id){
        this.user_id = user_id;
    }
    public String getUserName(){return userName;}

    public void setUserName(String userName){this.userName = userName;}

    public String getPassword(){return password;}

    public void setPassword(String password){this.password = password;}

    public String getProfile_info(){return profile_info;}

    public void setProfile_info(String profile_info) {this.profile_info = profile_info;}

    //provider stuff here
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int party_id;

    @Column(nullable = false)
    private String party_name;

    @Column(nullable = false)
    private String party_description;

    private String partyspace_icon;

    private String partyspace_banner;

    @Column(nullable = false)
    private String partyspace_privacy;

	public PartyPulse(String party_name, String party_description, String partyspace_icon, String partyspace_banner, String partyspace_privacy) {
        this.party_name = party_name;
        this.party_description = party_description;
        this.partyspace_icon = partyspace_icon;
        this.partyspace_banner = partyspace_banner;
        this.partyspace_privacy = partyspace_privacy;
    }

    public int getParty_id() {
        return party_id;
    }

    public void setParty_id(int party_id) {
        this.party_id = party_id;
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


    //admin stuff here

}
