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
import com.backend.models.Category;


@Controller
public class CategoryController {

	@Autowired
	CategoryDao categoryDao;
	
	
	@RequestMapping(value="getCategoryForm",method=RequestMethod.GET)
	public ModelAndView categoryForm(){
		Category categoryObj=new Category();
		
		ModelAndView mv=new ModelAndView("CategoryForm");
		mv.addObject("key1",categoryObj);
		mv.addObject("btnLabel","Add Category");
		mv.addObject("formLabel","Add Category Form");
		return mv;
	}
	@RequestMapping(value="submitCategory",method=RequestMethod.POST)
	public ModelAndView addCategory(@Valid@ModelAttribute("key1")Category cat,BindingResult result){
		
		if(result.hasErrors()) {
			
			
			ModelAndView mv=new ModelAndView("CategoryForm");
			mv.addObject("key1",cat);
			mv.addObject("btnLabel","Add Category");
			mv.addObject("formLabel","Add Category Form");
			return mv;
			
		}
		else {
			
		
		ModelAndView mv=new ModelAndView("ViewCategories");
		if(cat.getCategoryId()==0) {
			categoryDao.addCategory(cat);
			mv.addObject("message","Category Added Succesfully...");
		}
		else {
			categoryDao.updateCategory(cat);
			mv.addObject("message","Category Updated Succesfully...");
		}
		
		
		
		mv.addObject("categoriesList",categoryDao.getAllCategories());
		return mv;}
	}
	
	@RequestMapping(value="getAllCategories",method=RequestMethod.GET)
	public ModelAndView fetchAllCategories(){
		
		List<Category> categories=categoryDao.getAllCategories();
		
		ModelAndView mv=new ModelAndView("ViewCategories");
		mv.addObject("categoriesList",categories);
		return mv;
	}
	
	@RequestMapping(value="deleteCategory/{cId}",method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("cId")int catId){
		
		Category obj=categoryDao.getCategory(catId);
		categoryDao.deleteCategory(obj);
		
		ModelAndView mv=new ModelAndView("ViewCategories");
		mv.addObject("message","Category Deleted Succesfully...");
		mv.addObject("categoriesList",categoryDao.getAllCategories());
		return mv;
	}
	@RequestMapping(value="editCategory/{cId}",method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable("cId")int catId){
		
		Category obj=categoryDao.getCategory(catId);
		
		ModelAndView mv=new ModelAndView("CategoryForm");
		mv.addObject("key1",obj);
		mv.addObject("btnLabel","Edit Category");
		mv.addObject("formLabel","Edit Category Form");
		mv.addObject("op","Edit");
		return mv;
	}
}
