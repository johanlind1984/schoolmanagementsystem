package com.newtonprojectgroup.schoolmanagementsystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.Student;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryStudent;

@Controller
public class AttendanceController {
	
	@Autowired
	iRepositoryStudent repostudent;
	
	
	@GetMapping("/attendance")
	public String showForm(Model model) {
		Student student= new Student();
		model.addAttribute("student", student);
		
		//list of values of students
		List<Student> studentList = repostudent.findAll();
		model.addAttribute("studentList", studentList);
		
		return "attendance";
	}
	
	@ModelAttribute("multiCheckboxAllValues")
	public String[] getMultiCheckboxAllValues() {
	    return new String[] {
	        "Monday", "Tuesday", "Wednesday", "Thursday", 
	        "Friday", "Saturday", "Sunday"
	    };
	}

}
