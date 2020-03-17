package com.newtonprojectgroup.schoolmanagementsystem.Controller;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.Course;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.Credentials;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.Person;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.Program;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryCourse;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class startViewController {

    private Person user;
    private Credentials credentials;


    public startViewController() {
    }

    @RequestMapping("/greetuser")
    public String greetUser(Model theModel) {
        return "welcome-" + credentials.getUserPermission();
<<<<<<< HEAD
=======

>>>>>>> Projektgrupp
    }
  
    public void setUser(Person user) {
        this.user = user;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
}
