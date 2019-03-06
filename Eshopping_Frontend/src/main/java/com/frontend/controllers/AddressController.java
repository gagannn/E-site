package com.frontend.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.backend.daos.AddressDao;
import com.backend.daos.CartDao;
import com.backend.daos.CategoryDao;
import com.backend.daos.ProductDao;
import com.backend.models.Address;
import com.backend.models.Cart;
import com.backend.models.Category;
import com.backend.models.Product;
import com.backend.models.Supplier;
import com.backend.models.User;

@Controller
public class AddressController {
	@Autowired
	HttpSession session;

	@Autowired
	CartDao cartDao;

	@Autowired
	AddressDao addressDao;

	@Autowired
	CategoryDao categoryDao;

	@Autowired
	ProductDao productDao;

	@Autowired
	HttpServletRequest request;

	@RequestMapping(value="/addToCart/addressPage",method=RequestMethod.GET)
	public ModelAndView viewCart(){
		ModelAndView mv=new ModelAndView("AddressPage");
		String email=(String) session.getAttribute("userEmail");
		List<Address> address=addressDao.getAddressForUser(email);
		if(address.size()==0) {
			mv.addObject("msg","No addresses found");

		}
		else {
			mv.addObject("address", address);
		}
		List<Category> categories=categoryDao.getAllCategories();
		mv.addObject("categoriesList",categories);
		List<Product> products=productDao.getAllProducts();
		mv.addObject("productsList",products);
		return mv;
	}

	@RequestMapping(value="/addToCart/addressForm",method=RequestMethod.GET)
	public ModelAndView addressForm() {
		Address u=new Address();
		ModelAndView mv =new ModelAndView("AddressForm");
		List<Category> categories=categoryDao.getAllCategories();
		mv.addObject("categoriesList",categories);
		List<Product> products=productDao.getAllProducts();
		mv.addObject("productsList",products);
		mv.addObject("key1",u);
		mv.addObject("btnLabel","Add Address");
		mv.addObject("formLabel","User Address");
		return mv;

	}

	@RequestMapping(value="/addToCart/addAddress",method=RequestMethod.POST)
	public ModelAndView addAddress(@Valid@ModelAttribute("key1")Address address,BindingResult result) {

		if(result.hasErrors()) {

			ModelAndView mv=new ModelAndView("AddressForm");
			mv.addObject("key1",address);
			mv.addObject("btnLabel","Add Address");
			mv.addObject("formLabel","User Address");
			List<Category> categories=categoryDao.getAllCategories();
			mv.addObject("categoriesList",categories);
			List<Product> products=productDao.getAllProducts();
			mv.addObject("productsList",products);
			return mv;
		}
		ModelAndView mv=new ModelAndView("AddressPage");
		List<Category> categories=categoryDao.getAllCategories();
		mv.addObject("categoriesList",categories);
		List<Product> products=productDao.getAllProducts();
		mv.addObject("productsList",products);
		System.out.println("outside if "+address.getId() );
		if(address.getId()!=0) {
			System.out.println("inside if "+address.getId() );
			Principal p=request.getUserPrincipal();
			String userEmail=p.getName();
			User objj=(User) session.getAttribute("userObject");
			address.setUserObj(objj);
			boolean b=addressDao.updateAddress(address);
			System.out.println("*********************"+b+"**************");
			String email=(String) session.getAttribute("userEmail");
			List<Address> addresss=addressDao.getAddressForUser(email);
			mv.addObject("address", addresss);
			mv.addObject("message","Address Updated Succesfully...");
			return mv;
		}
		else {
			
		
		Principal p=request.getUserPrincipal();
		String userEmail=p.getName();
		//Cart cartObj=cartDao.getCartByCustomer(userEmail);
		//address.setCart(cartObj);
		User objj=(User) session.getAttribute("userObject");
		address.setUserObj(objj);
		boolean b=addressDao.insertAddress(address);
		}
		mv.addObject("message","Address Inserted Succesfully...");
		String email=(String) session.getAttribute("userEmail");
		List<Address> addresss=addressDao.getAddressForUser(email);
		if(addresss.size()==0) {
			mv.addObject("msg","No addresses found");

		}
		else {
			mv.addObject("address", addresss);
		}
		return mv;	
	}
	
	@RequestMapping(value="/addToCart/addressForm/{id}",method=RequestMethod.GET)
	public ModelAndView editAddress(@PathVariable("id")int addId){
		Address obj=addressDao.getAddressById(addId);
		ModelAndView mv=new ModelAndView("AddressForm");
		mv.addObject("key1",obj);
		
		List<Category> categories=categoryDao.getAllCategories();
		mv.addObject("categoriesList",categories);
		List<Product> products=productDao.getAllProducts();
		mv.addObject("productsList",products);
		mv.addObject("btnLabel","Edit Address");
		mv.addObject("formLabel","Edit Address Form");
		mv.addObject("op","Edit");
		return mv;
		
	}
	
	@RequestMapping(value="/addToCart/deleteAddress/{id}",method=RequestMethod.GET)
	public ModelAndView deleteAddress(@PathVariable("id")int addId){
		Address obj=addressDao.getAddressById(addId);
		addressDao.deleteAddress(obj);
		ModelAndView mv=new ModelAndView("AddressPage");
		String email=(String) session.getAttribute("userEmail");
		List<Address> address=addressDao.getAddressForUser(email);
		if(address.size()==0) {
			mv.addObject("msg","No addresses found");

		}
		else {
			mv.addObject("address", address);
		}
		List<Category> categories=categoryDao.getAllCategories();
		mv.addObject("categoriesList",categories);
		List<Product> products=productDao.getAllProducts();
		mv.addObject("productsList",products);
		mv.addObject("message","Address Deleted Succesfully...");
		return mv;
	}
}
