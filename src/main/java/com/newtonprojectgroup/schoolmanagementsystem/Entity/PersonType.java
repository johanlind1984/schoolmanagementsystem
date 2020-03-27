package com.newtonprojectgroup.schoolmanagementsystem.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="person_type")
public class PersonType {

    @Id
    @Column(name="idperson_type")
    private int personTypeId;

    @Column(name="person_type_title")
    private String personTypeTitle;

    @OneToMany(mappedBy="personType")
    private List<Person> personList;

    @OneToMany(mappedBy="personType")
    private List<AccountRequest> accountRequestList;

    public PersonType() {
    }

    public int getPersonTypeId() {
        return personTypeId;
    }

    public void setPersonTypeId(int personTypeId) {
        this.personTypeId = personTypeId;
    }

    public String getPersonTypeTitle() {
        return personTypeTitle;
    }

    public void setPersonTypeTitle(String personTypeTitle) {
        this.personTypeTitle = personTypeTitle;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
