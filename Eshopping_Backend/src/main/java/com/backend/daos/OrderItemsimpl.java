package com.backend.daos;

import javax.transaction.Transactional;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.backend.models.OrderItems;

@Repository("orderItemsDao")
@Transactional
public class OrderItemsimpl implements OrderItemsDao {
	
	@Autowired
	SessionFactory SessionFactory;

	@Override
	public boolean addOrderItems(OrderItems oi) {
		try {
			Session session=SessionFactory.getCurrentSession();
			session.save(oi);
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	
	}

}
