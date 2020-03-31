package com.newtonprojectgroup.schoolmanagementsystem.Controller;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.Credentials;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.Person;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.Program;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.Student;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class staffController {

    private Person person;
    public Credentials credentials;

    @Autowired
    private iRepositoryProgram repositoryProgram;

    public staffController() {
    }

    @RequestMapping("/staffview")
    public String staffView(Model theModel) {

        List<Program> programs = repositoryProgram.findAll();

        theModel.addAttribute("programs", programs);
        List<Student> students = repositoryProgram.findById(1).orElse(null).getStudentList();
        theModel.addAttribute("students", students);


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