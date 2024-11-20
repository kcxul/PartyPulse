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

    private String profile_des;

    @Column(nullable = false)
    private String user_email;

    public User(int user_id, String userName, String user_email, String password, String profile_des) {
        this.user_id = user_id;
        this.userName = userName;
        this.user_email = user_email;
        this.password = password;
        this.profile_des = profile_des;
    }

    public User(String userName, String user_email, String password, String profile_des) {
        this.userName = userName;
        this.user_email = user_email;
        this.password = password;
        this.profile_des = profile_des;
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

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfile_des() {
        return profile_des;
    }

    public void setProfile_des(String profile_des) {
        this.profile_des = profile_des;
    }

}
