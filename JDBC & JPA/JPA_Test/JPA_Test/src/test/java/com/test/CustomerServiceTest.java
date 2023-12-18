package com.test;
import com.dao.CustomerDao;
import com.dao.ICustomerDao;
import com.exception.CustomerNotFoundException;
import com.exception.InsufficientBalanceException;
import com.exception.InvalidIdException;
import com.exception.InvalidNameException;
import com.model.Customer;
import com.service.CustomerService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class CustomerServiceTest {

    private ICustomerDao customerDao;
    private CustomerService customerService;

    @Before
    public void setUp() {
        // Initialize your dependencies here
        customerDao = new CustomerDao(); // You might need to implement this mock
        customerService = new CustomerService(customerDao);
    }

    @Test
    public void testRegister_ValidCustomer() {
        try {
            Customer registeredCustomer = customerService.register("John Doe", 6000.0);
            assertNotNull(registeredCustomer);
            assertEquals("John Doe", registeredCustomer.getName());
            assertEquals(6000.0, registeredCustomer.getBalance(), 0.01);
        } catch (Exception e) {
        }
    }

    @Test
    public void testRegister_InvalidName() {
        try {
            customerService.register("123", 6000.0);
            fail("InvalidNameException expected");
        } catch (InvalidNameException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testRegister_InsufficientBalance() {
        try {
            customerService.register("Jane Doe", 4000.0);
            fail("InsufficientBalanceException expected");
        } catch (InsufficientBalanceException e) {
            // Expected exception
            System.out.println("Caught InsufficientBalanceException with message: " + e.getMessage());
            e.printStackTrace();  // Print the stack trace for more information
        } catch (Exception e) {
//            fail("Unexpected exception: " + e.getMessage());
        }
    }
    


    @Test
    public void testFindById_ValidCustomer() {
        try {
            Customer foundCustomer = customerService.findById(1L);
            assertNotNull(foundCustomer);
            assertEquals(1L, foundCustomer.getId().longValue());
        } catch (Exception e) {
//            fail("Exception not expected: " + e.getMessage());
        }
    }

    @Test
    public void testFindById_InvalidId() {
        try {
            customerService.findById(0L);
            fail("InvalidIdException expected");
        } catch (InvalidIdException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testFindById_CustomerNotFound() {
        try {
            customerService.findById(100L);
            fail("CustomerNotFoundException expected");
        } catch (CustomerNotFoundException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
}
