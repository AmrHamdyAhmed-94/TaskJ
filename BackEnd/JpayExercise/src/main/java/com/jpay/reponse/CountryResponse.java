package com.jpay.reponse;

import com.jpay.entities.Country;

public class CountryResponse {
	
	private Integer id;
	
	private String countryName;
	
	private String countryCode;
	
	private String countryRegex;
	
	public CountryResponse() {	}

	public CountryResponse(Integer id, String countryName, String countryCode, String countryRegex) {
		this.id = id;
		this.countryName = countryName;
		this.countryCode = countryCode;
		this.countryRegex = countryRegex;
	}
	
	public CountryResponse(Country country) {
		this.id = country.getId();
		this.countryName = country.getCountryName();
		this.countryCode = country.getCountryCode();
		this.countryRegex = country.getCountryRegex();
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
