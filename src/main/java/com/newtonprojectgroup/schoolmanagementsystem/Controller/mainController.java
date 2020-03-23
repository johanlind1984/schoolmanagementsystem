package com.newtonprojectgroup.schoolmanagementsystem.Controller;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.Credentials;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryCredentials;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller()
public class mainController {

    @Autowired
    private iRepositoryCredentials repositoryCredentials;

    @Autowired
    private iRepositoryPerson repositoryPerson;

    @Autowired
    private startViewController startViewController;

    @Autowired
    private staffController staffController;

    @RequestMapping("/")
    public String login(Model theModel) {
        theModel.addAttribute("credentials", new Credentials());
        return "login";
    }

    @RequestMapping("/checkcredentials")
    public ModelAndView checkCredentials(@ModelAttribute Credentials credentials, Model theModel) {
        System.out.println("Checking credentials");
        Credentials realCredentials = repositoryCredentials.findById(credentials.getUserName()).orElse(null);


        if (Arrays.equals(realCredentials.getPassword(), credentials.getPassword())) {
            startViewController.setUser(repositoryPerson.findById(credentials.getUserName()).orElse(null));
            startViewController.setCredentials(realCredentials);
            staffController.setUser(repositoryPerson.findById(credentials.getUserName()).orElse(null));
            staffController.setCredentials(realCredentials);

            switch (realCredentials.getUserPermission()) {
                case 1:
                    return new ModelAndView("redirect:/greetuser");
                case 2:
                    return new ModelAndView("redirect:/greetuser");
                case 3:
                    return new ModelAndView("redirect:/staffview");
                case 4:
                    System.out.println("adminstratorView model and view");
                    return new ModelAndView("redirect:/adminstartview");
                default:
                    return new ModelAndView("redirect:/greetuser");
            }
        }
        return new ModelAndView("redirect:/login-failed");

    }
}