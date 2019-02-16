package com.frontend.controllers;


import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
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

import com.backend.daos.CategoryDao;
import com.backend.daos.CategoryDaoImpl;
import com.backend.daos.ProductDao;
import com.backend.daos.SupplierDao;
import com.backend.models.Category;
import com.backend.models.Product;
import com.backend.models.Supplier;
import com.backend.validators.CategoryValidator;

@Controller
public class ProductController {

	@Autowired
	ProductDao productDao;
	
	@Autowired
	CategoryDao categoryDao;

	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	CategoryValidator categoryValidator;
	
	//@Autowired
	//SessionFactory SessionFactory;
	
	@RequestMapping(value="getProductForm",method=RequestMethod.GET)
	public ModelAndView productForm(){
		Product  productObj=new Product();
		
		ModelAndView mv=new ModelAndView("ProductForm");
		mv.addObject("key1",productObj);
		mv.addObject("btnLabel","Add Product");
		mv.addObject("formLabel","Add Product Form");

		List<Category> categoryList=categoryDao.getAllCategories();
		mv.addObject("catObj",categoryList);
		List<Supplier> supplierList=supplierDao.getAllSuppliers();
		mv.addObject("suppObj",supplierList);
		return mv;
	}
	@RequestMapping(value="submitProduct",method=RequestMethod.POST)
	public ModelAndView addProduct(@Valid@ModelAttribute("key1")Product prod,BindingResult result){
		categoryValidator.validate(prod, result);
		if(result.hasErrors()) {
		
			ModelAndView mv=new ModelAndView("ProductForm");
			
			List<Category> catList=categoryDao.getAllCategories();
			List<Supplier> sList=supplierDao.getAllSuppliers();
			
			mv.addObject("catObj",catList);
			mv.addObject("suppObj",sList);
			mv.addObject("formLabel","Add Product Form");
			mv.addObject("btnLabel","Add Product");
			return mv;
		}
		else {
			
		
		System.out.println("Product Obj = "+prod);
		ModelAndView mv=new ModelAndView("ViewProducts");
		
		if(prod.getProductId()==0)
		{
			
			HttpSession session=request.getSession();
				
			String filePathString = session.getServletContext().getRealPath("/");
			System.out.println("filePathString : "+filePathString);
			
			
			System.out.println("pimage : "+prod.getPimage1());
			//System.out.println("pimage2 : "+productObj.getPimage2());
			
			String fileName=prod.getPimage1().getOriginalFilename();
			//String fileName2=productObj.getPimage2().getOriginalFilename();

			System.out.println("filname  :"+fileName);
			
			//System.out.println("filname  :"+fileName2);

			
			prod.setImgname1(fileName);
			//productObj.setImgName2(fileName2);

			productDao.addProduct(prod);
			
			try{
				
				byte[] imageBytes=prod.getPimage1().getBytes();
				FileOutputStream fos=new FileOutputStream(filePathString+"/resources/images/"+fileName);
				BufferedOutputStream bos= new BufferedOutputStream(fos);
				bos.write(imageBytes);
				bos.close();
				
				//byte[] imageByte=prod.getPimage2().getBytes();
				//FileOutputStream foss=new FileOutputStream(filePathString+"/resources/images/"+fileName2);
				//BufferedOutputStream boss= new BufferedOutputStream(foss);
				//boss.write(imageByte);
				//boss.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			mv.addObject("msg","Product Added Successfully");
		
			
		}
		else
		{
			mv.addObject("messsage","Product Updated Successfully");
			productDao.updateProduct(prod);
		}
		//List<Category> categoryList=categoryDao.getAllCategories();
		//mv.addObject("catObj",categoryList);
		List<Product> pList=productDao.getAllProducts();
		mv.addObject("productsList", pList);
		return mv;}
	}
	
	@RequestMapping(value="getAllProducts",method=RequestMethod.GET)
	public ModelAndView fetchAllProducts(){
		
		List<Product> products=productDao.getAllProducts();
		System.out.println(products);
		ModelAndView mv=new ModelAndView("ViewProducts");
		mv.addObject("productsList",products);
		return mv;
	}
	
	@RequestMapping(value="deleteProduct/{pId}",method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("pId")int prodId){
		
		Product obj=productDao.getProductById(prodId);
		productDao.deleteProduct(obj);
		
		ModelAndView mv=new ModelAndView("ViewProducts");
		mv.addObject("message","Product Deleted Succesfully...");
		mv.addObject("productsList",productDao.getAllProducts());
		return mv;
	}
	@RequestMapping(value="editProduct/{pId}",method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable("pId")int prodId){
		
		Product obj=productDao.getProductById(prodId);
		
		ModelAndView mv=new ModelAndView("ProductForm");
		List<Category> categoryList=categoryDao.getAllCategories();
		mv.addObject("catObj",categoryList);
		List<Supplier> supplierList=supplierDao.getAllSuppliers();
		mv.addObject("suppObj",supplierList);
		mv.addObject("key1",obj);
		mv.addObject("btnLabel","Edit Product");
		mv.addObject("formLabel","Edit Product Form");
		mv.addObject("op","Edit");
		return mv;
	}
	
	
}
