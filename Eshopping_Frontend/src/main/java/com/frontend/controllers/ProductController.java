package com.frontend.controllers;


import java.io.BufferedOutputStream;
import java.io.File;
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
import com.backend.validators.ProductImageValidator;

@Controller
public class ProductController {

	@Autowired
	ProductDao productDao;
	
	@Autowired
	CategoryDao categoryDao;

	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	CategoryValidator categoryValidator;
	
	@Autowired
	ProductImageValidator productImageValidator;
	
	//@Autowired
	//SessionFactory SessionFactory;
	
	@RequestMapping(value="getProductForm",method=RequestMethod.GET)
	public ModelAndView productForm(){
		Product  productObj=new Product();
		
		ModelAndView mv=new ModelAndView("ProductForm");
		List<Category> categories=categoryDao.getAllCategories();
		mv.addObject("categoriesList",categories);
		List<Product> products=productDao.getAllProducts();
		mv.addObject("productsList",products);
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
		//productImageValidator.validate(prod, result);
		if(prod.getProductId()==0) {
			productImageValidator.validate(prod, result);
		}
		ModelAndView mv=null;
		if(result.hasErrors()) {
		
			mv=new ModelAndView("ProductForm");
			List<Category> categories=categoryDao.getAllCategories();
			mv.addObject("categoriesList",categories);
			List<Product> products=productDao.getAllProducts();
			mv.addObject("productsList",products);
			
			List<Category> catList=categoryDao.getAllCategories();
			List<Supplier> sList=supplierDao.getAllSuppliers();
			mv.addObject("key1",prod);
			mv.addObject("catObj",catList);
			mv.addObject("suppObj",sList);
			mv.addObject("formLabel","Add Product Form");
			mv.addObject("btnLabel","Add Product");
			return mv;
		}
		
			
		
		System.out.println("Product Obj = "+prod);
		mv=new ModelAndView("ViewProducts");
		List<Category> categories=categoryDao.getAllCategories();
		mv.addObject("categoriesList",categories);
		List<Product> products=productDao.getAllProducts();
		mv.addObject("productsList",products);
		
		if(prod.getProductId()==0)
		{
			
			//HttpSession session=request.getSession();
				
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

			//productDao.addProduct(prod);
			
			uploadImage(prod,filePathString,fileName);
			productDao.addProduct(prod);
			mv.addObject("message","Product Added Successfully");
		
			
		}
		else
		{
			if(prod.getPimage1().getSize()==0) {
				Product pro=productDao.getProductById(prod.getProductId());
				String img=pro.getImgname1();
				prod.setImgname1(img);
				productDao.updateProduct(prod);
			}
			else 
			{
				String filePathString = session.getServletContext().getRealPath("/");
				String fileName= prod.getPimage1().getOriginalFilename();
				prod.setImgname1(fileName);
				productDao.updateProduct(prod);
				//System.out.println("Hey here is size of file"+product.getPimage1().getContentType()+" "+product.getPimage1().getSize());
				uploadImage(prod, filePathString,fileName);
			}
		}
	//List<Category> categories=categoryDao.getAllCategories();
		mv.addObject("catObj",categories);
		//mv.addObject("title","Update Product");
		//mv.addObject("saveBtn", "Update");
		List<Product> list = productDao.getAllProducts();
		mv.addObject("productsList", list);
		return mv;
	}
	
	
	public void uploadImage(Product product,String filePathString,String fileName) {
		try{
			byte[] imageBytes=product.getPimage1().getBytes();
			String str=filePathString+"resources\\images\\";
			System.out.println(str);
			File file=new File(str);
			if(!file.exists()) {
				file.mkdirs();
			}
			FileOutputStream fos=new FileOutputStream(filePathString+"resources\\images\\"+fileName);
			BufferedOutputStream bos= new BufferedOutputStream(fos);
			bos.write(imageBytes);
			bos.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="getAllProducts",method=RequestMethod.GET)
	public ModelAndView fetchAllProducts(){
		
		List<Product> products=productDao.getAllProducts();
		System.out.println(products);
		ModelAndView mv=new ModelAndView("ViewProducts");
		List<Category> categories=categoryDao.getAllCategories();
		mv.addObject("categoriesList",categories);
		//List<Product> products=productDao.getAllProducts();
		//mv.addObject("productsList",products);
		mv.addObject("productsList",products);
		return mv;
	}
	
	@RequestMapping(value="deleteProduct/{pId}",method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("pId")int prodId){
		
		Product obj=productDao.getProductById(prodId);
		productDao.deleteProduct(obj);
		
		ModelAndView mv=new ModelAndView("ViewProducts");
		List<Category> categories=categoryDao.getAllCategories();
		mv.addObject("categoriesList",categories);
		List<Product> products=productDao.getAllProducts();
		mv.addObject("productsList",products);
		mv.addObject("message","Product Deleted Succesfully...");
		mv.addObject("productsList",productDao.getAllProducts());
		return mv;
	}
	
	@RequestMapping(value="getProductsByCategory/{categoryId}",method=RequestMethod.GET)
	public ModelAndView byCategory(@PathVariable("categoryId")int id){
		ModelAndView mv = new ModelAndView("ViewProducts");
		List<Product> list=productDao.viewAllProductByCategoryId(id);
	System.out.println("CatId: "+id);
		List<Category> categories=categoryDao.getAllCategories();
		mv.addObject("categoriesList",categories);
		mv.addObject("productsList", list);
		mv.addObject("CatName",categoryDao.getCategory(id).getCategoryName());
		System.out.println("CatId: "+id);
		System.out.println("Products: "+list);
		return mv;
	
	
	}
	
	@RequestMapping(value="editProduct/{pId}",method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable("pId")int prodId){
		
		Product obj=productDao.getProductById(prodId);
		
		ModelAndView mv=new ModelAndView("ProductForm");
		List<Category> categoryList=categoryDao.getAllCategories();
		mv.addObject("catObj",categoryList);
		List<Supplier> supplierList=supplierDao.getAllSuppliers();
		List<Category> categories=categoryDao.getAllCategories();
		mv.addObject("categoriesList",categories);
		List<Product> products=productDao.getAllProducts();
		mv.addObject("productsList",products);
		mv.addObject("suppObj",supplierList);
		mv.addObject("key1",obj);
		mv.addObject("productObj",obj);
		mv.addObject("btnLabel","Edit Product");
		mv.addObject("formLabel","Edit Product Form");
		mv.addObject("op","Edit");
		return mv;
	}
	
	@RequestMapping(value="/product/{pId}",method=RequestMethod.GET)
	public ModelAndView getProductById(@PathVariable("pId")int prodId){
		Product pro=productDao.getProductById(prodId);
		ModelAndView mv=new ModelAndView("Product");
		List<Category> categories=categoryDao.getAllCategories();
		mv.addObject("categoriesList",categories);
		List<Product> products=productDao.getAllProducts();
		mv.addObject("productsList",products);
		mv.addObject("prodObj",pro);
		return mv;
		
	}
	
	
	
}
