package com.jpay.reponse;

public class GetCustomerResponse {

	private Integer statusCode;
	
	private String errorMsg;
	
	private Iterable<CustomerResponse> customerResponseList;
	
	public GetCustomerResponse() {}

	public GetCustomerResponse(Integer statusCode, String errorMsg, Iterable<CustomerResponse> customerResponseList) {
		this.statusCode = statusCode;
		this.errorMsg = errorMsg;
		this.customerResponseList = customerResponseList;
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

	public Iterable<CustomerResponse> getCustomerResponseList() {
		return customerResponseList;
	}

	public void setCustomerResponseList(Iterable<CustomerResponse> customerResponseList) {
		this.customerResponseList = customerResponseList;
	}
}
