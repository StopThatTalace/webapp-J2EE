package com.tld.webapp.model;

public class User {

    private Integer id;
    private String username;
    private String email;
    private String password;
    private String registrationDate;

    public User() {
        // Default constructor
    }

    public User(Integer id, String username, String email, String password, String registrationDate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
                + ", registrationDate=" + registrationDate + "]";
    }
}
