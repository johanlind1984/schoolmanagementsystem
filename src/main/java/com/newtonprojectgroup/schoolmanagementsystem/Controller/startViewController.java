package com.newtonprojectgroup.schoolmanagementsystem.Controller;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.Credentials;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class startViewController {

    private Person user;
    private Credentials credentials;

    public startViewController() {
    }

    @RequestMapping("/greetuser")
    public String greetUser(Model theModel) {
        if(user!=null) {
            theModel.addAttribute("theuser", user);
            return "welcome-" + credentials.getUserPermission();
        }

        return "login-failed";

    }
    public void setUser(Person user) {
        this.user = user;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
}
