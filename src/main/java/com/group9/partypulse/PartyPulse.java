package com.group9.partypulse;


import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;

@Entity
@Table(name = "PartyPulse")
public class PartyPulse {

    //user stuff here first
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    private String profile_info;
    //provider stuff here
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int party_id;


    //admin stuff here

}
