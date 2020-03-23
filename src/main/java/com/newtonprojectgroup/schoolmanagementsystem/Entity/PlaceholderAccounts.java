package com.newtonprojectgroup.schoolmanagementsystem.Entity;

import javax.persistence.*;


@Entity
@Table(name = "placeholderaccounts")
public class PlaceholderAccounts {

    @Id
    @Column(name = "username_ph")
    private String username_ph;

    @Column(name = "password")
    private char[] password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "personal_number")
    private String personalNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "adress")
    private String adress;

    public PlaceholderAccounts() {
    }

    public String getUsername_ph() {
        return username_ph;
    }

    public void setUsername_ph(String username_ph) {
        this.username_ph = username_ph;
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

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }
}
