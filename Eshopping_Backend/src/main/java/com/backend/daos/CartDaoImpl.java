package com.backend.daos;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.backend.models.Address;
import com.backend.models.Cart;


@Repository("cartDao")
@Transactional
public class CartDaoImpl implements CartDao {

	@Autowired
	SessionFactory SessionFactory;
	
	@Override
	public boolean addCart(Cart cart) {
		try{
			Session session=SessionFactory.getCurrentSession();
		session.save(cart);
		return true;
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return false;
	}

	@Override
	public Cart getCartByCustomer(String customerId) {
		try{
			Session session=SessionFactory.getCurrentSession();
		Cart obj=(Cart)session.get(Cart.class, Integer.parseInt(customerId));

		return obj;
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return null;
	}

	@Override
	public boolean deleteCart(int cartId) {
		try{
			Session session=SessionFactory.getCurrentSession();
		Cart obj=(Cart)session.get(Cart.class, cartId);

		session.delete(obj);
		return true;
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return false;
	
	}

}
