package com.service;

import java.util.Optional;

import com.exception.InvalidIdException;
import com.exception.InvalidPriceException;
import com.exception.InvalidProductNameException;
import com.exception.OrderNotFoundException;
import com.model.CreatedOrder;

public interface IOrderService {
//    CreatedOrder createOrder(Long customerId, String productDesc, double productPrice)
//            throws InvalidIdException, InvalidProductNameException, InvalidPriceException;
//
//    CreatedOrder findById(Long orderId) throws InvalidIdException, OrderNotFoundException;
	
	CreatedOrder createOrder(Long customerId, String productDesc, double productPrice)
            throws InvalidIdException, InvalidProductNameException, InvalidPriceException;

    Optional<CreatedOrder> findById(Long orderId) throws InvalidIdException, OrderNotFoundException;
}
