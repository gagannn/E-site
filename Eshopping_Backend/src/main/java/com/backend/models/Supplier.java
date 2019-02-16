package com.backend.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="SupplierTable")
public class Supplier {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int supplierId;
	@NotEmpty
	private String suppName;
	@NotNull
	private Long suppMobile;
	@NotEmpty
	private String address;
	
	@OneToMany(mappedBy="supplier",cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
	private Set<Product> products=new HashSet<Product>();

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSuppName() {
		return suppName;
	}

	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}

	public Long getSuppMobile() {
		return suppMobile;
	}

	public void setSuppMobile(Long suppMobile) {
		this.suppMobile = suppMobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

}
