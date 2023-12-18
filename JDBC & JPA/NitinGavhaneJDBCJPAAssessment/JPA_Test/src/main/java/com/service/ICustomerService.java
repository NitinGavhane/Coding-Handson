package com.service;

import com.exception.CustomerNotFoundException;
import com.exception.InsufficientBalanceException;
import com.exception.InvalidIdException;
import com.exception.InvalidNameException;
import com.model.Customer;

public interface ICustomerService {
    Customer findById(Long id) throws InvalidIdException, CustomerNotFoundException;

    Customer register(String name, double balance) throws InvalidNameException, InsufficientBalanceException;
}
