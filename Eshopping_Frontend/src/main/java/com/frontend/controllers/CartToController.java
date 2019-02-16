package com.frontend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CartToController {

	@RequestMapping(value="/addToCart/{pId}",method=RequestMethod.GET)
	public String addToCart() {
		System.out.println("I m add To Cart method");
		return "AddToCart";
	}
	
}
