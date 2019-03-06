package com.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ItemOrderTable")
public class ItemOrder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int itemOrder;
	
	private Product product;
	
	
}
