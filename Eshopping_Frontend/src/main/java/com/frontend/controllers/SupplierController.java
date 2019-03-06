package com.frontend.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.backend.daos.CategoryDao;
import com.backend.daos.ProductDao;
import com.backend.daos.SupplierDao;
import com.backend.models.Category;
import com.backend.models.Product;
import com.backend.models.Supplier;

@Controller
public class SupplierController {
	
	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	
	@RequestMapping(value="getSupplierForm",method=RequestMethod.GET)
	public ModelAndView supplierForm() {
		
		Supplier supp=new Supplier();
		ModelAndView mv=new ModelAndView("SupplierForm");
		List<Category> categories=categoryDao.getAllCategories();
		mv.addObject("categoriesList",categories);
		List<Product> products=productDao.getAllProducts();
		mv.addObject("productsList",products);
		mv.addObject("key1",supp);
		mv.addObject("btnLabel","Add Supplier");
		mv.addObject("formLabel","Add Supplier Form");
		return mv;
	}
	@RequestMapping(value="submitSupplier",method=RequestMethod.POST)
	public ModelAndView addSupplier(@Valid@ModelAttribute("key1")Supplier supp,BindingResult result){

		if(result.hasErrors()) {
			
			ModelAndView mv=new ModelAndView("SupplierForm");
			List<Category> categories=categoryDao.getAllCategories();
			mv.addObject("categoriesList",categories);
			List<Product> products=productDao.getAllProducts();
			mv.addObject("productsList",products);
			mv.addObject("key1",supp);
			mv.addObject("btnLabel","Add Supplier");
			mv.addObject("formLabel","Add Supplier Form");
			return mv;
		}
		else {
			
		
		ModelAndView mv=new ModelAndView("ViewSuppliers");
		List<Category> categories=categoryDao.getAllCategories();
		mv.addObject("categoriesList",categories);
		List<Product> products=productDao.getAllProducts();
		mv.addObject("productsList",products);
		if(supp.getSupplierId()==0) {
			supplierDao.addSupplier(supp);
			mv.addObject("message","Supplier Added Succesfully...");
		}
		else {
			supplierDao.updateSupplier(supp);
			mv.addObject("message","Supplier Updated Succesfully...");
		}
		
		
		
		mv.addObject("supplierList",supplierDao.getAllSuppliers());
		return mv;}
	}
	
	@RequestMapping(value="getAllSuppliers",method=RequestMethod.GET)
	public ModelAndView fetchAllSuppliers(){
		
		List<Supplier> suppliers=supplierDao.getAllSuppliers();
		
		ModelAndView mv=new ModelAndView("ViewSuppliers");
		List<Category> categories=categoryDao.getAllCategories();
		mv.addObject("categoriesList",categories);
		List<Product> products=productDao.getAllProducts();
		mv.addObject("productsList",products);
		mv.addObject("supplierList",suppliers);
		return mv;
	}
	
	@RequestMapping(value="deleteSupplier/{sId}",method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("sId")int suppId){
		
		Supplier obj=supplierDao.getSupplier(suppId);
		supplierDao.deleteSupplier(obj);
		
		ModelAndView mv=new ModelAndView("ViewSuppliers");
		List<Category> categories=categoryDao.getAllCategories();
		mv.addObject("categoriesList",categories);
		List<Product> products=productDao.getAllProducts();
		mv.addObject("productsList",products);
		mv.addObject("message","Supplier Deleted Succesfully...");
		mv.addObject("supplierList",supplierDao.getAllSuppliers());
		return mv;
	}
	@RequestMapping(value="editSupplier/{sId}",method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable("sId")int suppId){
		
		Supplier obj=supplierDao.getSupplier(suppId);
		
		ModelAndView mv=new ModelAndView("SupplierForm");
		List<Category> categories=categoryDao.getAllCategories();
		mv.addObject("categoriesList",categories);
		List<Product> products=productDao.getAllProducts();
		mv.addObject("productsList",products);
		mv.addObject("key1",obj);
		mv.addObject("btnLabel","Edit Supplier");
		mv.addObject("formLabel","Edit Supplier Form");
		mv.addObject("op","Edit");
		return mv;
	}

}
