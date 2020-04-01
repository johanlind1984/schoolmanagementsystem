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
public class staffController {

    private Person person;
    public Credentials credentials;
    private List<Program> programList;

    @Autowired
    private iRepositoryStudent repositoryStudent;

    @Autowired
    private iRepositoryProgram repositoryProgram;

    public staffController() {
    }

//    @RequestMapping("/staffview")
//    public String staffView(Model theModel) {
//
//        List<Program> programs = repositoryProgram.findAll();
//
//
//        theModel.addAttribute("programs", programs);
//        theModel.addAttribute("Person", person);
//
//        return "faculty-view";
//    }


    //Skapa en knapp för att visa studenter i ett program
    @RequestMapping("/staffview")
    public String chosenProgram(
            @RequestParam(value = "chosen", required = false) Integer chosen, Model theModel) {

        if (chosen == null) {
            chosen = 1;
        }




        List<Program> programs = repositoryProgram.findAll();
        List<Student> students = repositoryProgram.findById(chosen).orElse(null).getStudentList();

            theModel.addAttribute("programs", programs);
            theModel.addAttribute("students", students);
            theModel.addAttribute("Person", person);

//            theModel.addAttribute("chosen", chosen);
//            List<Integer> chosenProgramID = Arrays.asList(1,2,3,4);
//            theModel.addAttribute("chosenProgramID", chosenProgramID);



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