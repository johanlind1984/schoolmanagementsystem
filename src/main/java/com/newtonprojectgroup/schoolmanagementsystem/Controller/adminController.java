package com.newtonprojectgroup.schoolmanagementsystem.Controller;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.AccountRequest;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.Credentials;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.Person;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class adminController {

    @Autowired
    private iRepositoryCourse repositoryCourse;

    @Autowired
    private iRepositoryStudent repositoryStudent;

    @Autowired
    private iRepositoryPerson repositoryPerson;

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


        return "admin-view-accountrequests";
    }

    @RequestMapping("/manageaccess")
    public String setPendingAccountAccess(
            @RequestParam( value = "permission", required = true) int permission,
            @RequestParam( value = "username") String userName) {

        if(permission == 0) {
            System.out.println("Deleting student from queue: " + userName);
            repositoryAccountRequests.deleteById(userName);
        } else {

            AccountRequest requestToSave = repositoryAccountRequests.findById(userName).orElse(null);
            Credentials newCredentials = new Credentials();
            newCredentials.setUserName(requestToSave.getUserName());
            newCredentials.setPassword(requestToSave.getPassword());
            newCredentials.setUserPermission(permission);

            Person newPerson = new Person();
            newPerson.setPersonId(requestToSave.getUserName());
            newPerson.setFirstName(requestToSave.getFirstName());
            newPerson.setLastName(requestToSave.getLastName());
            newPerson.setAdress(requestToSave.getAdress());
            newPerson.setEmail(requestToSave.getEmail());
            newPerson.setPersonalNumber(requestToSave.getPersonalNumber());
            newPerson.setPersonType(requestToSave.getPersonType());

            repositoryCredentials.save(newCredentials);
            repositoryPerson.save(newPerson);
            repositoryAccountRequests.deleteById(userName);
        }

        return "admin-view-accountrequests";
    }
}