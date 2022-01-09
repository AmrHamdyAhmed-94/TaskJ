package com.jpay.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "Country")
public class Country {

	@Id
	@NotNull
	@Column(name = "id" , columnDefinition = "int")
	private Integer id;
	
	@Column(name = "name" , columnDefinition = "varchar(50)")
	private String countryName;
	
	@Column(name = "code" , columnDefinition = "varchar(50)")
	private String countryCode;
	
	@Column(name = "regex" , columnDefinition = "varchar(50)")
	private String countryRegex;
	
	public Country() {	}

	public Country(String countryName, String countryCode, String countryRegex) {
		this.countryName = countryName;
		this.countryCode = countryCode;
		this.countryRegex = countryRegex;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryRegex() {
		return countryRegex;
	}

	public void setCountryRegex(String countryRegex) {
		this.countryRegex = countryRegex;
	}
}
