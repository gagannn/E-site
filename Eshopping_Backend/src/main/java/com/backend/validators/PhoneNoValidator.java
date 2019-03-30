package com.backend.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.backend.models.User;

@Component
public class PhoneNoValidator implements Validator{

	@Override
	public boolean supports(Class clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobileNo", "required.phone");
		if(errors!=null)
			return;
		User user =(User)target;
		if(user.getMobileNo().length()>10 ||  user.getMobileNo().length()<10) {
			errors.rejectValue("mobileNo", "notvalid.phone");
		}
	}

}
