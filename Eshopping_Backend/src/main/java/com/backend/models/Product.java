package com.backend.models;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NotFound;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;



@Entity(name="MyProductTab")
@Table
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productId;
	
	@NotEmpty
	private String productName;
	@NotNull
	private Double price;
	@NotNull
	private Integer quantity;
	private String description;

	@Transient
	MultipartFile pimage1;

	private String imgname1;

	private int categoryId;

	@ManyToOne
	@JoinColumn(name="supplierId",insertable=false,nullable=false,updatable=false)
	private Supplier supplier;


	@ManyToOne
	@JoinColumn(name="categoryId",insertable=false,nullable=false,updatable=false)
	private Category category;


	private int supplierId;

	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}


	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	public String getImgname1() {
		return imgname1;
	}
	public void setImgname1(String imgname1) {
		this.imgname1 = imgname1;
	}
	public MultipartFile getPimage1() {
		return pimage1;
	}
	public void setPimage1(MultipartFile pimage1) {
		this.pimage1 = pimage1;
	}

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}



}
