package com.newtonprojectgroup.schoolmanagementsystem.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.AccountRequest;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.PersonType;
import com.newtonprojectgroup.schoolmanagementsystem.Entity.Student;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryAccountRequests;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryPersonType;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.security.util.Password;

@Controller
@RequestMapping("/register")
public class NewRegistrationController {
	
	@Autowired
	iRepositoryAccountRequests accReqRepo;
	@Autowired
	iRepositoryPersonType persTypeRepo;

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
	@PostMapping ("/new")
	public String createAccountRequest(@ModelAttribute("accountrequest") AccountRequest accountRequest, Model model) {

		CharSequence seq = java.nio.CharBuffer.wrap(accountRequest.getPassword());
		accountRequest.setPassword(passwordEncoder.encode(seq).toCharArray());

		accReqRepo.save(accountRequest);
		return "redirect:/login";
	
}
}