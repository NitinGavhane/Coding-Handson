package com.dao;

import java.util.Optional;

import javax.persistence.EntityManager;

import com.model.Customer;

public interface ICustomerDao {
    Customer save(Customer customer);

    Optional<Customer> findById(Long id);

	EntityManager setEntityManager(EntityManager entityManager);
}
