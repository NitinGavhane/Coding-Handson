package com.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.model.Customer;

public class CustomerDao implements ICustomerDao {

    private EntityManager entityManager;

    // Setter for entityManager
    public EntityManager setEntityManager(EntityManager entityManager) {
        return this.entityManager = entityManager;
    }

    @Override
    public Customer save(Customer customer) {
        if (entityManager == null) {
            // You might want to throw an exception or log an error here
            System.err.println("EntityManager is not properly initialized.");
            return null;
        }
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(customer);
            transaction.commit();
            return customer;
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
    public Optional<Customer> findById(Long id) {
        if (entityManager == null) {
            // You might want to throw an exception or log an error here
            System.err.println("EntityManager is not properly initialized.");
            return Optional.empty();
        }
        return Optional.ofNullable(entityManager.find(Customer.class, id));
    }
}
