package com.frontend.controllers;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.backend.daos.CategoryDao;
import com.backend.daos.ProductDao;
import com.backend.daos.UserDao;
import com.backend.models.Category;
import com.backend.models.Product;
import com.backend.models.User;
import com.backend.validators.LoginValidator;
import com.backend.validators.MyPasswordValidator;
import com.backend.validators.PhoneNoValidator;


@Controller
public class UserController {

	@Autowired
	UserDao userDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	MyPasswordValidator myPasswordValidator;
	
	@Autowired
	PhoneNoValidator phoneNoValidator;
	
	@Autowired
	LoginValidator loginValidator;
	
	@RequestMapping(value="getSignupForm",method=RequestMethod.GET)
	public ModelAndView signupForm()
	{
		User u=new User();
		ModelAndView mv=new ModelAndView("SignupForm");
		List<Category> categories=categoryDao.getAllCategories();
		mv.addObject("categoriesList",categories);
		List<Product> products=productDao.getAllProducts();
		mv.addObject("productsList",products);
		mv.addObject("key1",u);
		mv.addObject("btnLabel","Signup");
		mv.addObject("formLabel","User Signup");
		return mv;
	}
	
	@RequestMapping(value="signupUser",method=RequestMethod.POST)
	public ModelAndView registerUser(@Valid@ModelAttribute("key1")User u, BindingResult result) {
		myPasswordValidator.validate(u, result);
		phoneNoValidator.validate(u, result);
		if(result.hasErrors()){
			ModelAndView mv=new ModelAndView("SignupForm");
			mv.addObject("key1",u);
			mv.addObject("btnLabel","Signup");
			mv.addObject("formLabel","User Signup");
			return mv;
		}
		u.setEnabled(true);
		u.setRole("Role_User");
		boolean r=userDao.registerUser(u);
		if(r)
		{
			ModelAndView mv=new ModelAndView("HomePage");
			List<Category> categories=categoryDao.getAllCategories();
			mv.addObject("categoriesList",categories);
			List<Category> threeCategories=categoryDao.threeCategories();
			mv.addObject("threeCategories",threeCategories);
			Map<Category,Product> threeRandomProducts=productDao.threeRandomProducts(threeCategories);
			mv.addObject("threeRandomProducts", threeRandomProducts);
			List<Product> products=productDao.getAllProducts();
			mv.addObject("productsList",products);
			List<Product> fourProducts=productDao.get4ProductFromEachCategory(categories);
			mv.addObject("fourProducts",fourProducts);
			mv.addObject("message","User Added Succesfully...");
			return mv;
			
		}
		else
		{
			ModelAndView mv=new ModelAndView("SignupForm");
			mv.addObject("message","Problem in adding user");
			mv.addObject("key1",u);
			return mv;
		}
	}
	
	@RequestMapping(value="Contact",method=RequestMethod.GET)
	public ModelAndView link()
	{
		System.out.println("I m HEre");
		ModelAndView mv=new ModelAndView("HomePage");
		return mv;
	}
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public ModelAndView loginForm(@RequestParam(name="error",required=false)String error)
	{
		
		//User u=new User();
		ModelAndView mv=new ModelAndView("LoginForm");
		if(error!=null) {
			mv.addObject("msg","Email or Password is incorrect...");
		}
		List<Category> categories=categoryDao.getAllCategories();
		mv.addObject("categoriesList",categories);
		List<Product> products=productDao.getAllProducts();
		mv.addObject("productsList",products);
		
		//mv.addObject("key1",u);
		mv.addObject("btnLabel","Login");
		mv.addObject("formLabel","User Login");
		return mv;
	}
	
	@RequestMapping(value="loginUser",method=RequestMethod.POST)
	public ModelAndView validateUser(@Valid@ModelAttribute("key1")User u, BindingResult result) {
		loginValidator.validate(u, result);
		if(result.hasErrors()){
			ModelAndView mv=new ModelAndView("LoginForm");
			mv.addObject("key1",u);
			mv.addObject("btnLabel","Login");
			mv.addObject("message","Login credentials invalid");
			mv.addObject("formLabel","User Login");
			return mv;
		}
		User r=userDao.validateUser(u);
		if(r!=null)
		{
			ModelAndView mv=new ModelAndView("HomePage");
			HttpSession session=request.getSession();
			session.setAttribute("userObject", r);
			mv.addObject("message","User Login Successful...");
			return mv;
		}
		else
		{
			ModelAndView mv=new ModelAndView("LoginForm");
			mv.addObject("message","Login credentials invalid");
			mv.addObject("key1",u);
			return mv;
		}
	}
	@RequestMapping(value="logoutUser",method=RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		
		//first we are going to fetch the authentication
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null){
			
			new SecurityContextLogoutHandler().logout(request, response, auth);
			
		}
		return "redirect:/";
	}
	
}
