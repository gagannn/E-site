package com.backend.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.backend.models.Product;

@Component
public class SupplierValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
Product product = (Product)target;
		
		ValidationUtils.rejectIfEmpty(errors, "supplierId", "required.selectSupplier");
		
		if(product.getSupplierId()==0) {
		errors.rejectValue("supplierId", "required.selectSupplier");
		}
	}

}
