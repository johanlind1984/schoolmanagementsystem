package com.newtonprojectgroup.schoolmanagementsystem.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public class indexController {

    @RequestMapping("/")
    public String goToStartView() {
        return "index";
    }
}