package com.jpay.reponse;

import java.util.List;

public class GetCountryResponse {

	private Integer statusCode;
	
	private String errorMsg;
	
	private List<CountryResponse> countryList;
	
	public GetCountryResponse() {}

	public GetCountryResponse(Integer statusCode, String errorMsg, List<CountryResponse> countryList) {
		this.statusCode = statusCode;
		this.errorMsg = errorMsg;
		this.countryList = countryList;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public List<CountryResponse> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<CountryResponse> countryList) {
		this.countryList = countryList;
	}
}
