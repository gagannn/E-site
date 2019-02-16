package com.frontend.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.backend.daos.CategoryDao;
import com.backend.daos.ProductDao;
import com.backend.daos.UserDao;
import com.backend.models.Category;
import com.backend.models.Product;
import com.backend.models.User;

@Controller
public class PageController {

	@Autowired
	UserDao userDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	private HttpServletRequest request;	
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView getHomePage(){
		Principal p=request.getUserPrincipal();
		
		
		if(p!=null){
			System.out.println("Principal active");
	
		String email=p.getName();
		User userObj=userDao.getUser(email);
		HttpSession session=request.getSession();
		session.setAttribute("userEmail", email);
		session.setAttribute("userObject",userObj);
		}
		ModelAndView mv=new ModelAndView("HomePage");
		List<Category> categories=categoryDao.getAllCategories();
		mv.addObject("categoriesList",categories);
		List<Product> products=productDao.getAllProducts();
		mv.addObject("productsList",products);
		return mv;
	}
	@RequestMapping(value="/access-denied",method=RequestMethod.GET)
	public String getAccessDenied(){
		return "ErrorPage";
		
	}
}

	