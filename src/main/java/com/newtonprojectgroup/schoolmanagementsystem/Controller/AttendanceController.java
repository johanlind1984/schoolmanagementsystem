package com.newtonprojectgroup.schoolmanagementsystem.Controller;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.Student;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
	
@GetMapping("/submit")
	public ModelAndView updateCount(@RequestParam("student") String studentId, Model model) {
		
		
		Student existingStudent = repostudent.findById(studentId).orElse(null);
	assert existingStudent != null;
	existingStudent.setCount(existingStudent.getCount()+1);
		repostudent.save(existingStudent);
				 
		 return new ModelAndView("redirect:/attendance");
	}
	
	
		

}
