package com.chapter_5.third.party.rest.API.Annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation , String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if(value == null)
			return false;
		List<String> roleList = List.of("ADMIN" , "USER");
		return roleList.contains(value);
	}
	

}
