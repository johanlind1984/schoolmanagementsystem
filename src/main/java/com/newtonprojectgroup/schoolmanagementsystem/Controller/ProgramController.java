package com.newtonprojectgroup.schoolmanagementsystem.Controller;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.Program;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.Student;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryProgram;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProgramController {

    @Autowired
    private iRepositoryProgram repositoryProgram;

    @Autowired
    private iRepositoryStudent repositoryStudent;

    private List<Student> studentList;
    private List<Program> programList;


    @RequestMapping("/program-list")
    public String programStartView(Model theModel) {

        theModel.addAttribute("programList", repositoryProgram.findAll());

        for (Program program : programList) {
            System.out.println(program.getProgramName());
        }

        return "programview";
    }


    @GetMapping("/faculty-view")
    public String activePrograms (Model theModel) {

        theModel.addAttribute("programs", repositoryProgram.findAll());
        theModel.addAttribute("studentList", repositoryStudent.findAll());

        for (Student student : studentList) {
            System.out.println(student.getEnlistedProgram().getProgramName());
        }

        return "programs/programList";
    }

    @RequestMapping("/view-active-students-program")
    public String participatingStudents (Model theModel) {

//        theModel.addAttribute("programList", repositoryProgram.findAll());
//        theModel.addAttribute("studentList", repositoryStudent.findAll());
//
//        for (Student student : studentList) {
//            System.out.println(student.getEnlistedProgram().getStudentList());
//        }


        List<Program> programList = repositoryProgram.findAll();

        theModel.addAttribute("programList", programList);


        return "view-program-list";
    }
}
