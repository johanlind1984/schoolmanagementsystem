package com.newtonprojectgroup.schoolmanagementsystem.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.Student;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryStudent;

@Controller
public class StudentController {
	
	@Autowired
	iRepositoryStudent studentRepo;

	@GetMapping ("/student")
	public String displayStudentInfo (Model model) {
		
		Student student=new Student();
		student=studentRepo.findById("HejHej").orElse (null);
		
		model.addAttribute("student", student);

		return "student-view";
		
	}
	
}
