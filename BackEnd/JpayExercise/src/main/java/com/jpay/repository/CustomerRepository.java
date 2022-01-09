package com.jpay.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpay.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , Integer> {
	

	@Transactional(readOnly = true)
	Page<Customer> findAll(Pageable pageable);
	
	@Query(nativeQuery= true , value = "SELECT * FROM customer Limit ?1 OFFSET ?2")
	List<Customer> findAll(Integer size , Integer offset);

}
