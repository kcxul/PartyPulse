package com.group9.partypulse;


import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;

@Entity
@Table(name = "PartyPulse")
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
        this.party_id = party_id;
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

    public int getParty_id(){return party_id;}

    public void setParty_id(int party_id) {this.party_id = party_id;}


    //admin stuff here

}
