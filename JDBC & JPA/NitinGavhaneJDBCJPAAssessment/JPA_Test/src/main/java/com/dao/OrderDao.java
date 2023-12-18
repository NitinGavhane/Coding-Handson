package com.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.model.CreatedOrder;

public class OrderDao implements IOrderDao {

    private EntityManager entityManager;

    // Setter for entityManager
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public CreatedOrder save(CreatedOrder createdOrder) {
        if (entityManager == null) {
            // You might want to throw an exception or log an error here
            System.err.println("EntityManager is not properly initialized.");
            return null;
        }
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(createdOrder);
            transaction.commit();
            return createdOrder;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            // handle the exception
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Optional<CreatedOrder> findById(Long id) {
        if (entityManager == null) {
            // You might want to throw an exception or log an error here
            System.err.println("EntityManager is not properly initialized.");
            return Optional.empty();
        }
        return Optional.ofNullable(entityManager.find(CreatedOrder.class, id));
    }
}
