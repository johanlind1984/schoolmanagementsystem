package com.newtonprojectgroup.schoolmanagementsystem.Controller;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.Credentials;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.Person;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.Staff;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class staffController {

    private Person user;
    private Credentials credentials;

    private List<Staff> staffList;

    @Autowired
    private iRepositoryStaff repositoryStaff;


    public staffController() {
    }

    @RequestMapping("/staffview")
    public String staffView(Model model) {

        staffList = repositoryStaff.findAll();

        for (Staff staff : staffList) {
            System.out.println("Name: " + staff.getFirstName() + " " + staff.getLastName());
            System.out.println("Role: " + staff.getPersonType().getPersonTypeTitle());
            System.out.println("StaffID: " + staff.getStaffId());
        }

        model.addAttribute("theuser", user);
        return "welcome-" + credentials.getUserPermission();
    }
}