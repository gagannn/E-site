package com.frontend.controllers;

import java.security.Principal;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.backend.daos.AddressDao;
import com.backend.daos.CartDao;
import com.backend.daos.CategoryDao;
import com.backend.daos.ItemDao;
import com.backend.daos.OrderDao;
import com.backend.daos.OrderItemsDao;
import com.backend.daos.PaymentDao;
import com.backend.daos.ProductDao;
import com.backend.daos.UserDao;
import com.backend.models.Address;
import com.backend.models.Cart;
import com.backend.models.Category;
import com.backend.models.Item;
import com.backend.models.Order;
import com.backend.models.OrderItems;
import com.backend.models.Payment;
import com.backend.models.Product;
import com.backend.models.User;
import com.backend.service.EmailService;
import com.backend.validators.PaymentValidator;

@Controller
public class CartController {
	@Autowired
	HttpSession session;

	@Autowired
	CartDao cartDao;

	@Autowired
	ItemDao itemDao;

	@Autowired
	HttpServletRequest request;

	@Autowired
	CategoryDao categoryDao;

	@Autowired
	UserDao userDao;

	@Autowired
	ProductDao productDao;

	@Autowired
	OrderItemsDao orderItemsDao;

	@Autowired
	OrderDao orderDao;

	@Autowired
	AddressDao addressDao;

	@Autowired
	PaymentDao paymentDao;

	@Autowired
	PaymentValidator paymentValidator;

	@Autowired
	EmailService emailService;

	static Address a;

	@RequestMapping(value="/addToCart/{pId}",method=RequestMethod.GET)
	public String addToCart(@PathVariable int pId) {
		System.out.println("I m add To Cart method");

		Principal p=request.getUserPrincipal();
		String userEmail=p.getName();

		Cart cartObj=cartDao.getCartByCustomer(userEmail);
		if(cartObj==null){
			System.out.println("Cart has not created yet");
			cartObj=new Cart();
			cartObj.setCustomerId(userEmail);
			cartDao.addCart(cartObj);
			System.out.println("Cart created");
		}	
		System.out.println("Cart already exist");
		Product pro=productDao.getProductById(pId);
		Item itemObj=itemDao.getItemByProductIdAndCustomerId(pro.getProductId(),userEmail);
		if(itemObj==null){
			itemObj=new Item();
			itemObj.setCart(cartObj);
			itemObj.setCustomerId(userEmail);
			itemObj.setPrice(pro.getPrice());
			itemObj.setProduct(pro);
			itemObj.setQuantity(1);
			itemDao.addItem(itemObj);
			System.out.println("Item Added in the Cart");
		}
		else {
			itemDao.increaseQuantity(itemObj.getItemId());
		}
		return "redirect:/";
	}

	@RequestMapping(value="/addToCart/viewCart",method=RequestMethod.GET)
	public ModelAndView viewCart(){

		Principal p=request.getUserPrincipal();
		String userEmail=p.getName();
		Cart cartObj=cartDao.getCartByCustomer(userEmail);
		ModelAndView mv=new ModelAndView("ViewCart");
		List<Category> categories=categoryDao.getAllCategories();
		mv.addObject("categoriesList",categories);
		List<Product> products=productDao.getAllProducts();
		mv.addObject("productsList",products);
		if((cartObj==null) || (cartObj.getItems().size()==0)){
			System.out.println("I m here 1");
			mv.addObject("itemsList","Not Found");
			//double d=itemDao.getTotalPrice(cartObj.getCartId());
			//mv.addObject("TotalPrice",d);
			return mv;
		}
		else {
			Collection<Item> items=cartObj.getItems();
			mv.addObject("itemsList",items);
			double d=itemDao.getTotalPrice(cartObj.getCartId());
			mv.addObject("TotalPrice",d);
			return mv;
		}
	}

	@RequestMapping(value="/addToCart/increase/{id}",method=RequestMethod.GET)
	public ModelAndView increaseQuantity(@PathVariable("id")int pId){
		Item i=itemDao.getItemByItemId(pId);
		if(i.getQuantity()<i.getProduct().getQuantity())
			itemDao.increaseQuantity(pId);
		Principal p=request.getUserPrincipal();
		String userEmail=p.getName();
		Cart cartObj=cartDao.getCartByCustomer(userEmail);
		ModelAndView mv=new ModelAndView("ViewCart");
		List<Category> categories=categoryDao.getAllCategories();
		mv.addObject("categoriesList",categories);
		List<Product> products=productDao.getAllProducts();
		mv.addObject("productsList",products);
		if((cartObj==null) || (cartObj.getItems().size()==0)){
			System.out.println("I m here 1");
			mv.addObject("itemsList","Not Found");
			double d=itemDao.getTotalPrice(cartObj.getCartId());
			mv.addObject("TotalPrice",d);
			return mv;
		}
		else {
			Collection<Item> items=cartObj.getItems();
			mv.addObject("itemsList",items);
			double d=itemDao.getTotalPrice(cartObj.getCartId());
			mv.addObject("TotalPrice",d);
			return mv;
		}
	}

	@RequestMapping(value="/addToCart/decrease/{id}",method=RequestMethod.GET)
	public ModelAndView decreaseQuantity(@PathVariable("id")int pId){
		Item i=itemDao.getItemByItemId(pId);
		if(i.getQuantity()==1) {
			itemDao.deleteItem(pId);
			Principal p=request.getUserPrincipal();
			String userEmail=p.getName();
			Cart cartObj=cartDao.getCartByCustomer(userEmail);
			ModelAndView mv=new ModelAndView("ViewCart");
			List<Category> categories=categoryDao.getAllCategories();
			mv.addObject("categoriesList",categories);
			List<Product> products=productDao.getAllProducts();
			mv.addObject("productsList",products);
			if((cartObj==null) || (cartObj.getItems().size()==0)){
				System.out.println("I m here 1");
				mv.addObject("itemsList","Not Found");
				//double d=itemDao.getTotalPrice(cartObj.getCartId());
				//mv.addObject("TotalPrice",d);
				return mv;
			}
			else {
				Collection<Item> items=cartObj.getItems();
				mv.addObject("itemsList",items);
				double d=itemDao.getTotalPrice(cartObj.getCartId());
				mv.addObject("TotalPrice",d);
				return mv;
			}
		}

		itemDao.decreaseQuantity(pId);
		Principal p=request.getUserPrincipal();
		String userEmail=p.getName();
		Cart cartObj=cartDao.getCartByCustomer(userEmail);
		ModelAndView mv=new ModelAndView("ViewCart");
		List<Category> categories=categoryDao.getAllCategories();
		mv.addObject("categoriesList",categories);
		List<Product> products=productDao.getAllProducts();
		mv.addObject("productsList",products);
		if((cartObj==null) || (cartObj.getItems().size()==0)){
			System.out.println("I m here 1");
			mv.addObject("itemsList","Not Found");
			double d=itemDao.getTotalPrice(cartObj.getCartId());
			mv.addObject("TotalPrice",d);
			return mv;
		}
		else {
			Collection<Item> items=cartObj.getItems();
			mv.addObject("itemsList",items);
			double d=itemDao.getTotalPrice(cartObj.getCartId());
			mv.addObject("TotalPrice",d);
			return mv;
		}
	}

	@RequestMapping(value="/addToCart/delete/{id}",method=RequestMethod.GET)
	public ModelAndView deleteItem(@PathVariable("id")int pId){
		Item i=itemDao.getItemByItemId(pId);
		itemDao.deleteItem(pId);
		Principal p=request.getUserPrincipal();
		String userEmail=p.getName();
		Cart cartObj=cartDao.getCartByCustomer(userEmail);
		ModelAndView mv=new ModelAndView("ViewCart");
		List<Category> categories=categoryDao.getAllCategories();
		mv.addObject("categoriesList",categories);
		List<Product> products=productDao.getAllProducts();
		mv.addObject("productsList",products);
		if((cartObj==null) || (cartObj.getItems().size()==0)){
			System.out.println("I m here 1");
			mv.addObject("itemsList","Not Found");
			//double d=itemDao.getTotalPrice(cartObj.getCartId());
			//mv.addObject("TotalPrice",d);
			return mv;
		}
		else {
			Collection<Item> items=cartObj.getItems();
			mv.addObject("itemsList",items);
			double d=itemDao.getTotalPrice(cartObj.getCartId());
			mv.addObject("TotalPrice",d);
			return mv;
		}	
	}

	@RequestMapping(value="/addToCart/payment/{id}",method=RequestMethod.GET)
	public ModelAndView getPayment(@PathVariable("id")int pId){
		a=addressDao.getAddressById(pId);
		System.out.println("A = "+a);
		Payment pay=new Payment();
		ModelAndView mv=new ModelAndView("Payment");
		mv.addObject("key1",pay);
		List<Category> categories=categoryDao.getAllCategories();
		mv.addObject("categoriesList",categories);
		List<Product> products=productDao.getAllProducts();
		mv.addObject("productsList",products);
		Principal p=request.getUserPrincipal();
		String userEmail=p.getName();
		Cart cartObj=cartDao.getCartByCustomer(userEmail);
		Collection<Item> items=cartObj.getItems();
		mv.addObject("itemsList",items);
		double d=itemDao.getTotalPrice(cartObj.getCartId());
		mv.addObject("TotalPrice",d);
		int size=0;
		for(Item item:items){
			size=size+item.getQuantity();
		}
		mv.addObject("items",size);
		return mv;	
	}


	@RequestMapping(value="/addToCart/payment/placeOrder",method=RequestMethod.POST)
	public ModelAndView placeOrder(@Valid@ModelAttribute("key1")Payment pp,BindingResult result){
		System.out.println(a);
		paymentValidator.validate(pp, result);
		if(result.hasErrors()) {
			ModelAndView mv=new ModelAndView("Payment");
			mv.addObject("key1",pp);
			List<Category> categories=categoryDao.getAllCategories();
			mv.addObject("categoriesList",categories);
			List<Product> products=productDao.getAllProducts();
			mv.addObject("productsList",products);
			Principal p=request.getUserPrincipal();
			String userEmail=p.getName();
			Cart cartObj=cartDao.getCartByCustomer(userEmail);
			Collection<Item> items=cartObj.getItems();
			mv.addObject("itemsList",items);
			double d=itemDao.getTotalPrice(cartObj.getCartId());
			mv.addObject("TotalPrice",d);
			int size=0;
			for(Item item:items){
				size=size+item.getQuantity();
			}
			mv.addObject("items",size);
			return mv;	
		}
		ModelAndView mv=new ModelAndView("OrderPlaced");
		List<Category> categories=categoryDao.getAllCategories();
		mv.addObject("categoriesList",categories);
		List<Product> products=productDao.getAllProducts();
		mv.addObject("productsList",products);
		Order o=new Order();
		o.setAddress(a);
		//for payment
		pp.setOrder(o);
		paymentDao.addPayment(pp);
		//for OrderItems
		Principal p=request.getUserPrincipal();
		String userEmail=p.getName();
		o.setUser(userDao.getUser(userEmail));
		Set<OrderItems> orderSet=new HashSet<>();
		Cart cartObj=cartDao.getCartByCustomer(userEmail);
		Collection<Item> items=cartObj.getItems();
		for(Item i:items) {
			OrderItems oi=new OrderItems();
			oi.setProductObj(i.getProduct());
			oi.setQuantity(i.getQuantity());
			oi.setItemPrice(i.getProduct().getPrice()*i.getQuantity());
			oi.setOrderObj(o);
			orderItemsDao.addOrderItems(oi);
			orderSet.add(oi);
			Product pro=i.getProduct();
			pro.setQuantity(pro.getQuantity()-i.getQuantity());
			productDao.updateProduct(pro);
		}
		o.setItems(orderSet);
		o.setTotalAmountPaid(itemDao.getTotalPrice(cartObj.getCartId()));
		orderDao.makeOrder(o);
		cartDao.deleteCart(cartObj.getCartId());
		User userObj=userDao.getUser(userEmail);
		emailService.sendThankuMsg(userObj, "Your order has been processed succesfully. Order id is "+o.getOrderId());
		return mv;
	}
	
}
