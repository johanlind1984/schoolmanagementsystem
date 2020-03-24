package com.newtonprojectgroup.schoolmanagementsystem.Controller;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.AccountRequest;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.Credentials;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

    @Autowired
    private iRepositoryAccountRequests repositoryAccountRequests;



    @RequestMapping("/adminstartview")
    public String administratorStartView(Model theModel) {

        theModel.addAttribute("courseList", repositoryCourse.findAll());
        theModel.addAttribute("studentList", repositoryStudent.findAll());
        theModel.addAttribute("programList", repositoryProgram.findAll());
        theModel.addAttribute("credential", new Credentials());



        List<AccountRequest> list = repositoryAccountRequests.findAll();
        theModel.addAttribute("accountRequestsList", list);


        for (AccountRequest accountRequest: list) {
            System.out.println(accountRequest.getEmail());
        }


        return "admin-view";
    }
}
