package com.backend.daos;

import com.backend.models.Order;
import com.backend.models.Payment;

public interface PaymentDao {
	public boolean addPayment(Payment payment);
}
