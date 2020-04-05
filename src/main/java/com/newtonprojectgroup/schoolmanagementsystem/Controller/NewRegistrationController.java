package com.newtonprojectgroup.schoolmanagementsystem.Controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.AccountRequest;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.Credentials;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.PersonType;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryAccountRequests;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryCredentials;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryPersonType;
import com.newtonprojectgroup.schoolmanagementsystem.Service.SaveAccountRequestValidator;

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
		
		Credentials credentials=credRepo.findById(accountRequest.getUserName()).orElse(null);
		if (!credentials==null) {
			return "accountRequest";
		}else {
			CharSequence seq = java.nio.CharBuffer.wrap(accountRequest.getPassword());
			accountRequest.setPassword(passwordEncoder.encode(seq).toCharArray());
			
			
			accReqRepo.save(accountRequest);
			
		}
		return "welcome-new-account";

		
	
}
//	@PostMapping ("/save")
//	public String createAccountRequest(@ModelAttribute("accountrequest") AccountRequest accountRequest, Model model) {
//
//		CharSequence seq = java.nio.CharBuffer.wrap(accountRequest.getPassword());
//		accountRequest.setPassword(passwordEncoder.encode(seq).toCharArray());
//		
//		
//		accReqRepo.save(accountRequest);
//		return "redirect:/newAccount";
//	
//}
//	@PostMapping ("/save")
//	public String saveAccountRequest (@ModelAttribute("accountrequest") @Valid AccountRequest accountRequest, BindingResult bindingResult) {
//		new SaveAccountRequestValidator().validate (accountRequest, bindingResult);
//			if(bindingResult.hasErrors()) {
//				return "accountrequest";
//			}else {
//			CharSequence seq = java.nio.CharBuffer.wrap(accountRequest.getPassword());
//			accountRequest.setPassword(passwordEncoder.encode(seq).toCharArray());
//			accReqRepo.save(accountRequest);
//		}
//		return "welcome-new-account";
//	}
//	
	
	
	
//	@GetMapping("/newAccount")
	
//	public String displayWelcomeNewAccount(Model model) {
//		return"welcome-new-account";
//	}
	
	
	
}