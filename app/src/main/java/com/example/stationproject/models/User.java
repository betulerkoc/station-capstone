package com.example.stationproject.models;

public class User {

    private int userID;
    private String name;
    private String surname;
    private String email;
    private String userAddress;

    public User(String name, String surname, String email, String userAddress) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.userAddress = userAddress;
    }

    public User() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
