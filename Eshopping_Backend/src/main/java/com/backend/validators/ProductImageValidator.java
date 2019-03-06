package com.backend.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.backend.models.Product;

@Component
public class ProductImageValidator implements Validator{

	@Override
	public boolean supports(Class img) {
		return Product.class.isAssignableFrom(img);
	}
	@Override
	public void validate(Object target, Errors error) {
		Product product = (Product)target;
		if(product.getPimage1()!=null && product.getPimage1().isEmpty()) {
			error.rejectValue("pimage1","required.image" );
		}
	}

}