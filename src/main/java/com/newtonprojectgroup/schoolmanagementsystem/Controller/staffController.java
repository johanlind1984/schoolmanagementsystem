package com.newtonprojectgroup.schoolmanagementsystem.Controller;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.Credentials;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class staffController {

    private Person person;
    public Credentials credentials;

    public staffController() {
    }

    @RequestMapping("/staffview")
    public String staffView(Model theModel) {


        theModel.addAttribute("Person", person);
        return "welcome-3";
    }

    public void setUser(Person person) {
        this.person = person;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
}