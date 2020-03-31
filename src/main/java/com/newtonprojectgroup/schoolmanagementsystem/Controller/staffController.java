package com.newtonprojectgroup.schoolmanagementsystem.Controller;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.*;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryPersonType;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryProgram;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class staffController {

    private PersonType personType;
    private Person person;
    public Credentials credentials;

    @Autowired
    private iRepositoryPersonType repositoryPersonType;
    @Autowired
    private iRepositoryStudent repositoryStudent;
    @Autowired
    private iRepositoryProgram repositoryProgram;

    public staffController() {
    }

    @RequestMapping("/staffview")
    public String staffView(Model theModel) {

        List<PersonType> personTypes = repositoryPersonType.findAll();
        List<Student> students = repositoryStudent.findAll();
        List<Program> programs = repositoryProgram.findAll();

        for (PersonType person : personTypes) {
            if(person.getPersonTypeId() == 3) {
                theModel.addAttribute("students", students);
                theModel.addAttribute("programs", programs);
            }
        }



        theModel.addAttribute("Person", person);

        return "faculty-view";
    }

    public void setUser(Person person) {
        this.person = person;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
}