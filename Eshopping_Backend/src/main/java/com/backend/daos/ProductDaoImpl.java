package com.backend.daos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.persistence.Query;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.backend.models.Category;
import com.backend.models.Product;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory SessionFactory;

	public boolean addProduct(Product product) {
		try{
			Session session=SessionFactory.getCurrentSession();
			session.save(product);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}	

	public boolean deleteProduct(Product obj) {
		try{
			Session session=SessionFactory.getCurrentSession();
			session.delete(obj);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateProduct(Product product) {
		try{
			Session session=SessionFactory.getCurrentSession();
			session.update(product);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public Product getProductById(int pId) {
		try{
			Session session=SessionFactory.getCurrentSession();
			Product obj=(Product)session.get(Product.class, pId);
			return obj;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public List<Product> getAllProducts() {
		try{
			Session session=SessionFactory.getCurrentSession();
			Criteria c=session.createCriteria(Product.class);
			List<Product> cList=c.list();
			System.out.println(cList);
			return cList;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> viewAllProductByCategoryId(int categoryId) {
		try {
			Session session = SessionFactory.getCurrentSession();
			Query q = session.createQuery("from MyProductTab where categoryId=:x");
			q.setParameter("x",categoryId);
			List<Product> list =q.getResultList();
			System.out.println("\n\n\n\n\n\n\n\nList: "+list);
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("\n\n\n\nreturning null");
		return null;
	}

	@Override
	public Map<Category,Product> threeRandomProducts(List<Category> c) {
		Map<Category,Product> pp=new HashMap<>();
		for(Category obj: c) {
			pp.put(obj,getProduct(obj));
		}
		return pp;

	}

	@Override
	public Product getProduct(Category c) {
		int size=c.getProducts().size();
		int item = 0;//new Random().nextInt(size);
		int i = 0;
		for(Product obj : c.getProducts())
		{
			if (i == item)
				return obj;
			i++;
		}
		return null;
	}

	@Override
	public List<Product> get4ProductFromEachCategory(List<Category> cat) {
		List<Product> p=new ArrayList<>();
		List<Product> allProducts=getAllProducts();
		int count=0;
		for(Category c:cat) {
			count=0;
			for(Product prod:allProducts) {
				if(prod.getCategoryId()==c.getCategoryId()) {
					if(count<4) {
						p.add(prod);
						count++;
					}
				}
			}
		}
		return p;
	}
	
}
