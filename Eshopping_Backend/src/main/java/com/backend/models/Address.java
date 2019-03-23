package com.backend.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="AddressTable_04")
public class Address {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@NotNull(message="House No. is mandatory")
	private Integer houseNumber;
	@NotEmpty(message="Locality is mandatory")
	private String locality;
	@NotEmpty(message="City is mandatory")
	private String city;
	@NotEmpty(message="State is mandatory")
	private String state;
	@NotEmpty(message="Pin Code is mandatory")
	private String pinCode;
	@NotEmpty(message="Country is mandatory")
	private String country;
	
	@ManyToOne
	@JoinColumn(name="UserEmail")
	private User userObj;
		
	//@OneToOne(mappedBy="address",cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
	//private Order order;
	
	
	public User getUserObj() {
		return userObj;
	}
	public void setUserObj(User userObj) {
		this.userObj = userObj;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(Integer houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	

}
