package com.ericStuff.uIInterface;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {
	private String name;
	private String address;
	
	@Id
	private Integer customerID;
	
	private Integer waterUsed;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getCustomerID() {
		return customerID;
	}
	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}
	public Integer getWaterUsed() {
		return waterUsed;
	}
	public void setWaterUsed(Integer waterUsed) {
		this.waterUsed = waterUsed;
	}
	
	
}
