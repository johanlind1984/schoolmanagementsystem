package com.newtonprojectgroup.schoolmanagementsystem.Controller;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.Credentials;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryCredentials;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller()
public class MainController {

    @GetMapping("/student")
    public ModelAndView studentView() {
        return new ModelAndView("redirect:/studentview");
    }

    @GetMapping("/staff")
    public ModelAndView staffView() {
        return new ModelAndView("redirect:/staffview");
    }

    @GetMapping("/admin")
    public ModelAndView adminView() {
        return new ModelAndView("redirect:/admin/accountrequests");
    }

}