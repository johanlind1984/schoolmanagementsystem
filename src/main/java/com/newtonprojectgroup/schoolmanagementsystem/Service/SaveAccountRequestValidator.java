package com.newtonprojectgroup.schoolmanagementsystem.Service;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.AccountRequest;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryPerson;

public class SaveAccountRequestValidator implements Validator {
	
	iRepositoryPerson credRepo;

	@Override
	public boolean supports(Class<?> clazz) {
		
		return AccountRequest.class.equals(clazz);
	}
	


	@Override
	public void validate(Object user, Errors e) {
		AccountRequest accountRequest=(AccountRequest) user;
		
		if (credRepo.findAll().contains(accountRequest.getUserName())) {
			e.rejectValue("userName", "UserNameAlreadyExists");
		}

	}

}
