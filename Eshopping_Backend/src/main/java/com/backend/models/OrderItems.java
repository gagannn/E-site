package com.backend.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class OrderItems {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderItemsId;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="productId")
	private Product productObj;

	private int quantity;
	private double itemPrice;

	@ManyToOne
	@JoinColumn(name="orderId")
	private Order orderObj;

	public int getOrderItemsId() {
		return orderItemsId;
	}

	public void setOrderItemsId(int orderItemsId) {
		this.orderItemsId = orderItemsId;
	}

	public Product getProductObj() {
		return productObj;
	}

	public void setProductObj(Product productObj) {
		this.productObj = productObj;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Order getOrderObj() {
		return orderObj;
	}

	public void setOrderObj(Order orderObj) {
		this.orderObj = orderObj;
	}

}
