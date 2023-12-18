package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.dao.ICustomerDao;
import com.model.Customer;

public class StubCustomerDao implements ICustomerDao {

	private Map<Long, Customer> customers = new HashMap<>();
	private long id = 1;

	@Override
	public Customer save(Customer customer) {
		customer.setId(id++); // Assigning ID (for testing purposes)
		customers.put(customer.getId(), customer);
		return customer;
	}

	@Override
	public Optional<Customer> findById(Long id) {
		return Optional.ofNullable(customers.get(id));
	}

	@Override
	public EntityManager setEntityManager(EntityManager entityManager) {
		// TODO Auto-generated method stub
		return null;
	}
}
