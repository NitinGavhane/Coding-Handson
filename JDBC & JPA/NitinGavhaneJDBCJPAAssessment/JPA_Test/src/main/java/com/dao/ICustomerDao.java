package com.dao;

import java.util.Optional;

import com.model.Customer;

public interface ICustomerDao {
    Customer save(Customer customer);

    Optional<Customer> findById(Long id);
}
