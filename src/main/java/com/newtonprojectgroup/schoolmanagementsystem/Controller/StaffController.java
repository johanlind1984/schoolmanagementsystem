package com.newtonprojectgroup.schoolmanagementsystem.Controller;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.Credentials;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.Person;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.Program;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.Student;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryProgram;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {

    private Person person;
    public Credentials credentials;
    private List<Program> programList;

    @Autowired
    private iRepositoryStudent repositoryStudent;

    @Autowired
    private iRepositoryProgram repositoryProgram;

    public StaffController() {
    }

    @RequestMapping("/")
    public String staffView(Model theModel) {


        List<Program> programs = repositoryProgram.findAll();
        theModel.addAttribute("programs", programs);
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