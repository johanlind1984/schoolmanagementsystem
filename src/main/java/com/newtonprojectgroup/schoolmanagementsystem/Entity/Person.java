package com.newtonprojectgroup.schoolmanagementsystem.Entity;

import javax.persistence.*;

@Entity
@Table(name="person")
public class Person {

    @Id
    @Column(name="person_username")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String studentId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="PIN")
    private String personalIdentityNumber;

    @Column(name="email")
    private String email;

    @Column(name="adress")
    private String adress;

    public Person() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    public String getPersonalIdentityNumber() {
        return personalIdentityNumber;
    }

    public void setPersonalNumber(String personalIdentityNumber) {
        this.personalIdentityNumber = personalIdentityNumber;
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

}
