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
import org.springframework.web.bind.annotation.RequestParam;

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

    //Skapa en knapp för att visa studenter i ett program
    @RequestMapping("/chosenprogram")
    public String chosenProgram(@RequestParam("program") int chosenProgramId, Model theModel) {
        List<Program> programs = repositoryProgram.findAll();
        Program program = repositoryProgram.findById(chosenProgramId).orElse(null);
        List<Student> studentList = program.getStudentList();
        theModel.addAttribute("programs", programs);
        theModel.addAttribute("chosenProgram", program);
        theModel.addAttribute("studentList", studentList);

    return "faculty-view";
    }


    public void setUser(Person person) {
        this.person = person;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
}