package com.backend.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="OrderTable_04")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	
	@OneToOne
	@JoinColumn(name="email")
	private User user; 
	
	
	@OneToOne
	@JoinColumn(name="id")
	private Address address;
	
	@OneToMany(mappedBy="orderObj",cascade=CascadeType.ALL)
	Set<OrderItems> items=new HashSet<>();

	private double totalAmountPaid;
	
	public double getTotalAmountPaid() {
		return totalAmountPaid;
	}


	public void setTotalAmountPaid(double totalAmountPaid) {
		this.totalAmountPaid = totalAmountPaid;
	}


	public Set<OrderItems> getItems() {
		return items;
	}


	public void setItems(Set<OrderItems> items) {
		this.items = items;
	}
	
	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}

}
