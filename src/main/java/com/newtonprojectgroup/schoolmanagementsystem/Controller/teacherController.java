package com.newtonprojectgroup.schoolmanagementsystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.Teacher;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryPerson;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryTeacher;
import com.newtonprojectgroup.schoolmanagementsystem.Service.TeacherService;

@Controller
public class teacherController {
	
	@Autowired
	private TeacherService service;
	
	@Autowired
	iRepositoryPerson repoperson;
	
	@Autowired
	iRepositoryTeacher repoteacher;
	
	@GetMapping("/teacher")
	public String viewTeacherPage(Model model) {
		Teacher teacher= repoteacher.findById("nils").orElse(null);
		model.addAttribute("teacher", teacher);	
		
		
		
		return "teacher";
	}
	
	@GetMapping("/edit")
	public String editTeacher(Model model) {
		System.out.println("submit");
		Teacher teacher = repoteacher.findById("nils").orElse(null);
		model.addAttribute("teacher", teacher);
		
		return "edit_teacher";
	}
	
/*@RequestMapping("/edit")
	public ModelAndView editTeacher(@PathVariable(name = "idteacher") String idteacher) {
		ModelAndView mav = new ModelAndView("edit_teacher");
		Teacher teacher = service.get(idteacher);
		mav.addObject("teacher", teacher);
		
		return "edit_teacher";
	}*/

@RequestMapping(value = "/edit_teacher/submit", method = RequestMethod.POST)
public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
	service.save(teacher);
	
	return "redirect:/teacher";
}


}
