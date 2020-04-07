package com.newtonprojectgroup.schoolmanagementsystem.Controller;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.Person;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.Program;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.Student;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.Teacher;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryPerson;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryProgram;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryTeacher;
import com.newtonprojectgroup.schoolmanagementsystem.Service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class teacherController {

	@Autowired
	private TeacherService service;
	
	@Autowired
	private iRepositoryPerson repoperson;
	
	@Autowired
	private iRepositoryTeacher repoteacher;

	@Autowired
	private iRepositoryProgram repositoryProgram;
	
	@RequestMapping("/")
	public String viewTeacherPage(Principal principal, Model model) {


		List<Program> programs = repositoryProgram.findAll();
		Person person = repoperson.findById(principal.getName()).orElse(null);

		model.addAttribute("programs", programs);
		model.addAttribute("Person", person);

		return "teacher";
	}
	
	
	@GetMapping("/edit")
	public String editTeacher(Principal principal, Model model) {
		
		Person person = repoperson.findById(principal.getName()).orElse(null);
		model.addAttribute("Person", person);
		
		return "edit_teacher";
	}
	

	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public ModelAndView updateInformation(Principal principal,
	            @RequestParam("firstName") String firstName,
	            @RequestParam("lastName") String lastName,
	            @RequestParam("adress") String adress,
	            @RequestParam("email") String email) {

	        Person personFromDB = repoperson.findById(principal.getName()).orElse(null);

	        assert personFromDB != null;
	        personFromDB.setFirstName(firstName);
	        personFromDB.setLastName(lastName);
	        personFromDB.setAdress(adress);
	        personFromDB.setEmail(email);

	        repoperson.save(personFromDB);

	        return new ModelAndView("redirect:/teacher/");
	    }



		
	@RequestMapping("/chosenprogram")
	public String chosenProgram(Principal principal, Model theModel,
								@RequestParam(value = "program") int chosenProgramId) {

		Person person = repoperson.findById(principal.getName()).orElse(null);
		List<Program> programs = repositoryProgram.findAll();
		Program program = repositoryProgram.findById(chosenProgramId).orElse(null);
		assert program != null;
		List<Student> studentList = program.getStudentList();


		theModel.addAttribute("programTitle", program.getProgramName());
		theModel.addAttribute("programs", programs);
		theModel.addAttribute("chosenProgram", program);
		theModel.addAttribute("studentList", studentList);
		theModel.addAttribute("Person", person);

		return "teacher";
	}
}
