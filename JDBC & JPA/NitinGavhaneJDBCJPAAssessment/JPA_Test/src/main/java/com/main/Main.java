package com.main;

import java.util.Optional;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.dao.CustomerDao;
import com.dao.ICustomerDao;
import com.dao.IOrderDao;
import com.dao.OrderDao;
import com.model.CreatedOrder;
import com.model.Customer;
import com.service.CustomerService;
import com.service.ICustomerService;
import com.service.IOrderService;
import com.service.OrderService;

public class Main {
    public static void main(String[] args) {
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecommercePU");
        EntityManager entityManager = emf.createEntityManager();

        ICustomerDao customerDao = new CustomerDao();
        ((CustomerDao) customerDao).setEntityManager(entityManager);

        ICustomerService customerService = new CustomerService(customerDao);       
        IOrderDao orderDao = new OrderDao();
        ((OrderDao) orderDao).setEntityManager(entityManager);

        IOrderService orderService = new OrderService(orderDao, customerService);


        Scanner scanner = new Scanner(System.in);

        // Register a customer
        System.out.println("-------Register a new customer-----");
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter customer balance: ");
        double customerBalance = scanner.nextDouble();

        try {
            Customer registeredCustomer = customerService.register(customerName, customerBalance);
            System.out.println("Customer registered successfully. ID: " + registeredCustomer.getId());
        } catch (Exception e) {
            System.out.println("Error registering customer: " + e.getMessage());
        }

        // Find a customer by ID
        System.out.println("\n-------Find customer by ID---------");
        System.out.print("Enter customer ID: ");
        long customerIdToFind = scanner.nextLong();

        try {
            Customer foundCustomer = customerService.findById(customerIdToFind);
            System.out.println("Found Customer: " + foundCustomer);
        } catch (Exception e) {
            System.out.println("Error finding customer: " + e.getMessage());
        }

        // Create an order
        System.out.println("\n-------Create a new order--------");
        System.out.print("Enter customer ID for the order: ");
        long orderCustomerId = scanner.nextLong();

        System.out.print("Enter product name for the order: ");
        String orderProductName = scanner.next();

        System.out.print("Enter product price for the order: ");
        double orderProductPrice = scanner.nextDouble();

        try {
            CreatedOrder createdOrder = orderService.createOrder(orderCustomerId, orderProductName, orderProductPrice);
            System.out.println("Order created successfully. Order ID: " + createdOrder.getId());
        } catch (Exception e) {
            System.out.println("Error creating order: " + e.getMessage());
        }

        // Find an order by ID
        System.out.println("\n--------Find order by ID---------");
        System.out.print("Enter order ID: ");
        long orderIdToFind = scanner.nextLong();

        try {
            Optional<CreatedOrder> foundOrder = orderService.findById(orderIdToFind);
            foundOrder.ifPresentOrElse(
                    order -> System.out.println("Found Order: " + order),
                    () -> System.out.println("Order not found for ID: " + orderIdToFind)
            );
        } catch (Exception e) {
            System.out.println("Error finding order: " + e.getMessage());
        }
    }
}
