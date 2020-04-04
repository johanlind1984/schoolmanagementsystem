package com.newtonprojectgroup.schoolmanagementsystem.Controller;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.*;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryPerson;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryProgram;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {

    private Person person;
    public Credentials credentials;
    private List<Program> programList;

    @Autowired
    private iRepositoryPerson repositoryPerson;

    @Autowired
    private iRepositoryStaff repositoryStaff;

    @Autowired
    private iRepositoryProgram repositoryProgram;

    public StaffController() {
    }

    @RequestMapping("/")
    public String staffView(Principal principal, Model theModel) {


        List<Program> programs = repositoryProgram.findAll();
        Person person = repositoryPerson.findById(principal.getName()).orElse(null);

        theModel.addAttribute("programs", programs);
        theModel.addAttribute("Person", person);


        return "faculty-view";
    }

    @RequestMapping("/chosenprogram")
    public String chosenProgram(@RequestParam("program") int chosenProgramId, Principal principal, Model theModel) {

        Person person = repositoryPerson.findById(principal.getName()).orElse(null);
        List<Program> programs = repositoryProgram.findAll();
        Program program = repositoryProgram.findById(chosenProgramId).orElse(null);
        List<Student> studentList = program.getStudentList();

        theModel.addAttribute("programs", programs);
        theModel.addAttribute("chosenProgram", program);
        theModel.addAttribute("studentList", studentList);
        theModel.addAttribute("Person", person);

        return "faculty-view";
    }

//    @RequestMapping("/staffview")
//    public String chosenProgram(
//            @RequestParam( value = "chosen", required = true) int chosen, Model theModel) {
//
//        if(chosen == 0) {
//            System.out.println(chosen);
//            List<Student> students = repositoryProgram.findById(chosen).orElse(null).getStudentList();
//
//            programList = repositoryProgram.findAll();
//            List<Program> programs = repositoryProgram.findAll();
//
//            theModel.addAttribute("programs", programs);
//            theModel.addAttribute("students", students);
//            System.out.println(chosen);
//        }
//
//        return "faculty-view";
//    }

    public void setUser(Person person) {
        this.person = person;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;

    }
}