package com.backend.daos;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.backend.models.Order;

@Repository("orderDao")
@Transactional
public class OrderDaoImpl implements OrderDao {

	@Autowired
	SessionFactory SessionFactory;
	
	@Override
	public int makeOrder(Order order) {
		try{
			Session session=SessionFactory.getCurrentSession();
		session.save(order);
		return 1;
	}
	catch(Exception e){
		e.printStackTrace();
	}
	return 0;
	}

}
