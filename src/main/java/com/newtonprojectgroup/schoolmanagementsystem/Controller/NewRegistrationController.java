package com.newtonprojectgroup.schoolmanagementsystem.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.AccountRequest;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.PersonType;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryAccountRequests;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryPersonType;

@Controller
public class NewRegistrationController {
	
	@Autowired
	iRepositoryAccountRequests accReqRepo;
	@Autowired
	iRepositoryPersonType persTypeRepo;
	
	@GetMapping("/new")
	public String displayRegistrationForm (Model model) {
		AccountRequest accountRequest =new AccountRequest();
		
		List<PersonType>personTypeList=persTypeRepo.findAll();
		
		model.addAttribute("accountrequest", accountRequest);
		model.addAttribute("allPersonTypes", personTypeList);
		
		
		return "accountrequest";
		
	}
	@PostMapping ("/new")
	public String createAccountRequest(@ModelAttribute("personTypeId") AccountRequest accountRequest, Model model) {
		

		
		accReqRepo.save(accountRequest);
		return "redirect:/new";
	
}
}