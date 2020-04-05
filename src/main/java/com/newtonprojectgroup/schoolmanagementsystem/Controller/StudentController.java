package com.newtonprojectgroup.schoolmanagementsystem.Controller;



import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.Person;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.Student;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryCredentials;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryPerson;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryStudent;

@Controller
public class StudentController {
	
	@Autowired
	iRepositoryStudent studentRepo;
	
	@Autowired
	iRepositoryCredentials credRepo;
	
	@Autowired
	iRepositoryPerson personRepo;

	@GetMapping ("/student")
	public String displayStudentInfo (Model model, Principal principal) {
		
		Student student=studentRepo.findById(principal.getName()).orElse(null);
		
		Person person=personRepo.findById(principal.getName()).orElse(null);
		model.addAttribute("student", student);
		model.addAttribute("person", person);

		return "student-view";
		
	}
	//Tillägg efter merge. Stefan har gjort update
//	@RequestMapping(value = "/update", method = RequestMethod.POST)
//    public ModelAndView updateInformation(Principal principal,
//            @RequestParam("firstName") String firstName,
//            @RequestParam("lastName") String lastName,
//            @RequestParam("adress") String adress,
//            @RequestParam("email") String email) {
//
//        Person personFromDB = personRepo.findById(principal.getName()).orElse(null);
//        assert personFromDB != null;
//        personFromDB.setFirstName(firstName);
//        personFromDB.setLastName(lastName);
//        personFromDB.setAdress(adress);
//        personFromDB.setEmail(email);
//
//        personRepo.save(personFromDB);
//
//        return new ModelAndView("redirect:/student/");
//    }
	
}
