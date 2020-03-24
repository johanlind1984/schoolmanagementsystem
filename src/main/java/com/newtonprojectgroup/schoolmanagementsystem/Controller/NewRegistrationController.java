package com.newtonprojectgroup.schoolmanagementsystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.AccountRequest;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.Person;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryAccountRequests;

@Controller
public class NewRegistrationController {
	
	@Autowired
	iRepositoryAccountRequests accReqRepo;

	@GetMapping("/new")
	public String displayRegistrationForm(Model model) {
		
		AccountRequest anAccountRequest=new AccountRequest();
		
		model.addAttribute("accountrequest", anAccountRequest);
		
		return "accountrequest";
	}
	
	@PostMapping ("/save")
	public String createAccountRequest(AccountRequest accountRequest, Model model) {
		 accReqRepo.save(accountRequest);
		 
		 return "redirect:/new";
	}
}
