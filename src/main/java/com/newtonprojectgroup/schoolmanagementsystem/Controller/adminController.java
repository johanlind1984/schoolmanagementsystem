package com.newtonprojectgroup.schoolmanagementsystem.Controller;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.Credentials;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryCourse;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryCredentials;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryProgram;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class adminController {

    @Autowired
    private iRepositoryCourse repositoryCourse;

    @Autowired
    private iRepositoryStudent repositoryStudent;

    @Autowired
    private iRepositoryProgram  repositoryProgram;

    @Autowired
    private iRepositoryCredentials repositoryCredentials;



    @RequestMapping("/adminstartview")
    public String administratorStartView(Model theModel) {

        theModel.addAttribute("courseList", repositoryCourse.findAll());
        theModel.addAttribute("studentList", repositoryStudent.findAll());
        theModel.addAttribute("programList", repositoryProgram.findAll());
        theModel.addAttribute("credential", new Credentials());

        System.out.println(repositoryCredentials.findAll().size());
        theModel.addAttribute("credentialsList", repositoryCredentials.findAll());


        return "admin-view";
    }
}
