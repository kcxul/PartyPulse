package com.group9.partypulse.user;


import jakarta.persistence.*;

@Entity
@Table()
public class User {

    //user stuff here
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    private String profile_info;

    public User(int user_id, String userName, String password, String profile_info) {
        this.user_id = user_id;
        this.userName = userName;
        this.password = password;
        this.profile_info = profile_info;
    }

    public User(String userName, String password, String profile_info) {
        this.userName = userName;
        this.password = password;
        this.profile_info = profile_info;
    }

    public User() {
    }

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
}
