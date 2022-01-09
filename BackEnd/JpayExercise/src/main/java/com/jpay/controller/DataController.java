package com.jpay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jpay.reponse.CountryResponse;
import com.jpay.reponse.CustomerResponse;
import com.jpay.reponse.GetCountryResponse;
import com.jpay.service.DataService;

@RestController
@RequestMapping(path = "/data")
public class DataController {
	
	@Autowired
	private DataService dataService;
	
    @GetMapping(value="/getallcountries")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public GetCountryResponse getAllCountriesData(){
    	
    	GetCountryResponse getCountriesResponse;
    	try {
    		List<CountryResponse> countryList = dataService.getAllCountriesData();
    		getCountriesResponse = new GetCountryResponse(null , null , countryList);
    	}catch(Exception ex) {
    		getCountriesResponse = new GetCountryResponse(HttpStatus.BAD_REQUEST.value() , ex.getMessage() , null);
    	}
    	return getCountriesResponse;
    }
    
    @GetMapping(value="/getallcustomers")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Page<CustomerResponse> getAllCustomersData(@RequestParam(name = "page", defaultValue = "0") int page,
    		@RequestParam(name = "size", defaultValue = "10") int size){

		Page<CustomerResponse> customerResponseList = dataService.getAllCustomersData(page , size);

    	return customerResponseList;
    }
}
