package com.newtonprojectgroup.schoolmanagementsystem.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.AccountRequest;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.PersonType;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.Student;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryAccountRequests;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryCredentials;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryPersonType;

@Controller
@RequestMapping("/register")
public class NewRegistrationController {
	
	@Autowired
	iRepositoryAccountRequests accReqRepo;
	@Autowired
	iRepositoryPersonType persTypeRepo;
	@Autowired
	iRepositoryCredentials credRepo;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	@GetMapping("/new")
	public String displayRegistrationForm (Model model) {
		AccountRequest accountRequest =new AccountRequest();
		
		List<PersonType>personTypeList=persTypeRepo.findAll();
		
		
		
		model.addAttribute("accountrequest", accountRequest);
		model.addAttribute("allPersonTypes", personTypeList);
		
		
		return "accountrequest";
		
	}
	
	@PostMapping ("/save")
	public String createAccountRequest(@ModelAttribute("accountrequest") AccountRequest accountRequest, Model model) {
		
		if (credRepo.findById(accountRequest.getUserName()).orElse(null) !=  null || 
				accReqRepo.findById(accountRequest.getUserName()).orElse(null) != null) {
			System.out.println("Användarnamn upptaget");
		
			List<PersonType>personTypeList=persTypeRepo.findAll();
			
			model.addAttribute("accountrequest", accountRequest);
			model.addAttribute("allPersonTypes", personTypeList);
			
			
			
			return "accountRequest";
			
		}else {
			CharSequence seq = java.nio.CharBuffer.wrap(accountRequest.getPassword());
			accountRequest.setPassword(passwordEncoder.encode(seq).toCharArray());
			
			accReqRepo.save(accountRequest);
			
		}
		return "welcome-new-account";
	
	
	
	
}
}