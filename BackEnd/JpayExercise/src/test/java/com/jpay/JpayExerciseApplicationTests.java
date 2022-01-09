package com.jpay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpay.entities.Customer;
import com.jpay.repository.CustomerRepository;

@SpringBootTest
class JpayExerciseApplicationTests {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	void TestGetCustomer_offset0_Size41() {
		int size = 41;
		int offset = 0;
		List<Customer> customerList = customerRepository.findAll(size, offset);
		assertFalse(customerList.isEmpty());
		assertEquals(customerList.size(), size);
		assertEquals(customerList.get(0).getId(), 0);
	}
	
	@Test
	void TestGetCustomer_offset1_Size41() {
		int size = 41;
		int offset = 1;
		List<Customer> customerList = customerRepository.findAll(size, offset);
		assertFalse(customerList.isEmpty());
	}
	
	@Test
	void TestGetCustomer_offset4_size10() {
		int size = 10;
		int offset = 4*10;
		List<Customer> customerList = customerRepository.findAll(size, offset);
		assertFalse(customerList.isEmpty());
		assertEquals(customerList.get(0).getId(), 40);
	}
	
	@Test
	void TestGetCustomer_offset5_size10() {
		int size = 10;
		int offset = 5*10;
		List<Customer> customerList = customerRepository.findAll(size, offset);
		assertTrue(customerList.isEmpty());
	}

}
