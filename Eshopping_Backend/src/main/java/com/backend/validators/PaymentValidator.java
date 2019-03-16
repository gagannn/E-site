package com.backend.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.backend.models.Payment;
import com.backend.models.User;

@Component
public class PaymentValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Payment pay=(Payment)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cvv", "required.cvv");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cardNo", "required.cardNo");
	
		if((pay.getCvv()!=null)&&(String.valueOf(pay.getCvv()).length()!=3)) {
			errors.rejectValue("cvv", "cvv.size");
		}
		if((!pay.getCardNo().isEmpty())&&(String.valueOf(pay.getCardNo()).length()!=16)) {
			errors.rejectValue("cardNo", "cardno.size");
		}
		
	}

}
