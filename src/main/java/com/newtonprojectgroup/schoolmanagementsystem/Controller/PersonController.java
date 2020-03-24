package com.newtonprojectgroup.schoolmanagementsystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.Person;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryPerson;

@Controller
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	iRepositoryPerson persRepo;

	@GetMapping("/new")
	public String displayPersonForm(Model model) {
		
		Person aPerson=new Person();
		
		model.addAttribute("person", aPerson);
		
		return "new-person";
	}
	
	@PostMapping ("/save")
	public String createPerson(Person person, Model model) {
		 persRepo.save(person);
		 
		 return "redirect:/person/new";
	}
}
