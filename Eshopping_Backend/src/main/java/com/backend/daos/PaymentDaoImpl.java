package com.backend.daos;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.backend.models.Payment;

@Repository("paymentDao")
@Transactional
public class PaymentDaoImpl implements PaymentDao {

	@Autowired
	SessionFactory SessionFactory;
	
	@Override
	public boolean addPayment(Payment payment) {
		try {
			Session session=SessionFactory.getCurrentSession();
			session.save(payment);
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

}
