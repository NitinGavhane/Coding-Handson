package com.dao;

import java.util.Optional;

import com.model.CreatedOrder;

public interface IOrderDao {
    CreatedOrder save(CreatedOrder createdOrder);

    Optional<CreatedOrder> findById(Long id);
}
