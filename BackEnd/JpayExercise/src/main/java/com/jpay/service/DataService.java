package com.jpay.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jpay.entities.Country;
import com.jpay.entities.Customer;
import com.jpay.exception.NoDataFound;
import com.jpay.reponse.CountryResponse;
import com.jpay.reponse.CustomerResponse;
import com.jpay.repository.CountryRepository;
import com.jpay.repository.CustomerRepository;

@Service
public class DataService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	public List<CountryResponse> getAllCountriesData(){
		List<Country> countryList = countryRepository.findAll();
		if(countryList == null || countryList.isEmpty()) throw new NoDataFound("Couldn't Find Any Data For The Countries");
		List <CountryResponse> countryResponseList = countryList.stream().map(country -> new CountryResponse(country)).collect(Collectors.toList()); 
		return countryResponseList;
	}
	
	public Page<CustomerResponse> getAllCustomersData(int page , int size){
		PageRequest pageRequest = PageRequest.of(page, size , Sort.by("id").ascending());
		Page<Customer> pageResult = customerRepository.findAll(pageRequest);
		List<Customer> customerList = customerRepository.findAll(size , (page*size));
		List<CustomerResponse> customerResponseList =  customerList.stream().map(customer -> new CustomerResponse(customer)).collect(Collectors.toList());
		return new PageImpl<CustomerResponse>(customerResponseList, pageRequest, pageResult.getTotalElements());
	}
}



//Found a problem if the page number 2 or above it returns the same data from page 1 no matter the size 
//if(page < 2) {
//	customerResponseList = pageResult.stream().map(CustomerResponse::new).collect(Collectors.toList());
//	if(customerResponseList == null ) throw new NoDataFound("Couldn't Find Any Data For The Customers");
//	
//	return new PageImpl<CustomerResponse>(customerResponseList, pageRequest, pageResult.getTotalElements());
//
//}else {
//	
// this will take alot from the memory as it will retrieve all the data from the DB and then filter it
//
//List<Customer> customerList = customerRepository.findAll();
//	customerList = customerList.subList((page * size), ((page * size)+size));
//	for(int i = 0 ; i < customerList.size() ; ++i) {
//		customerResponseList.add(new CustomerResponse(customerList.get(i)));
//	}
//}
