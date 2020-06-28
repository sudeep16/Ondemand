package com.agile.ondemand.model;

public class User {
    private String firstName;
    private String lastName;
    private String address;
    private String username;
    private String email;
    private String phone;
    private String gender;
    private String password;

    public User(String firstName, String lastName, String address, String username, String email, String phone, String gender, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
