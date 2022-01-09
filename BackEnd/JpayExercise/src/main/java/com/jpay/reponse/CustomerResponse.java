package com.jpay.reponse;

import com.jpay.entities.Customer;


public class CustomerResponse {
	
	private Integer id;
	
	private String name;
	
	private String phone;
	
	public CustomerResponse() {}

	public CustomerResponse(Integer id, String name, String phone) {
		this.id = id;
		this.name = name;
		this.phone = phone;
	}
	
	public CustomerResponse(Customer customer) {
		this.id = customer.getId();
		this.name = customer.getName();
		this.phone = customer.getPhone();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
