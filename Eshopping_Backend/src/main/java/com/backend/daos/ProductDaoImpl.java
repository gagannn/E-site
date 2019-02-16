package com.backend.daos;




import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.backend.models.Product;


@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory SessionFactory;

	public boolean addProduct(Product product) {
		try{
			System.out.println("I m in addProduct method of Dao");
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


	
}
