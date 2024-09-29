package com.spring.chapter_2.Annotations;

import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

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
