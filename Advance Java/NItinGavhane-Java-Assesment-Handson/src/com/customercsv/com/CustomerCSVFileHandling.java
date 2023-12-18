package com.customercsv.com;
import java.io.*; 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Customer {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Customer(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + salary;
    }
}

interface ICustomerService {
    void insertCustomer(int id, String name, String department, double salary);
    List<Customer> readCustomers();
    List<Customer> sortCustomersById(boolean ascending);
    Customer getCustomerWithHighestSalary();
}

class CustomerService implements ICustomerService {
    private static final String CUSTOMERS_FILE_PATH = "customers.csv";

    @Override
    public void insertCustomer(int id, String name, String department, double salary) {
        try {
            FileWriter writer = new FileWriter(CUSTOMERS_FILE_PATH, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            printWriter.println(id + "," + name + "," + department + "," + salary);
            printWriter.close();

            System.out.println("Customer data inserted successfully.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Customer> readCustomers() {
        List<Customer> customers = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(CUSTOMERS_FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String department = data[2];
                    double salary = Double.parseDouble(data[3]);
                    customers.add(new Customer(id, name, department, salary));
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return customers;
    }

    @Override
    public List<Customer> sortCustomersById(boolean ascending) {
        List<Customer> customers = readCustomers();
        customers.sort(ascending ? Comparator.comparing(Customer::getId) : Comparator.comparing(Customer::getId).reversed());
        return customers;
    }

    @Override
    public Customer getCustomerWithHighestSalary() {
        List<Customer> customers = readCustomers();
        if (customers.isEmpty()) {
            return null;
        }
        return Collections.max(customers, Comparator.comparing(Customer::getSalary));
    }
}

public class CustomerCSVFileHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ICustomerService customerService = new CustomerService();

        while (true) {
            System.out.println("\nA company has the customers data in csv file, The company wants to process on the file and retrieve data:");
            System.out.println("********************************************");
            System.out.println("1. Insert customer data into CSV file");
            System.out.println("2. Read customer data from CSV file");
            System.out.println("3. Sort customers by ID (Ascending)");
            System.out.println("4. Sort customers by ID (Descending)");
            System.out.println("5. Show customer with highest salary");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter customer ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter customer department: ");
                    String department = scanner.nextLine();
                    System.out.print("Enter customer salary: ");
                    double salary = scanner.nextDouble();
                    customerService.insertCustomer(id, name, department, salary);
                    break;
                case 2:
                    List<Customer> customers = customerService.readCustomers();
                    for (Customer customer : customers) {
                        System.out.println(customer);
                    }
                    break;
                case 3:
                    List<Customer> ascendingCustomers = customerService.sortCustomersById(true);
                    for (Customer customer : ascendingCustomers) {
                        System.out.println(customer);
                    }
                    break;
                case 4:
                    List<Customer> descendingCustomers = customerService.sortCustomersById(false);
                    for (Customer customer : descendingCustomers) {
                        System.out.println(customer);
                    }
                    break;
                case 5:
                    Customer highestSalaryCustomer = customerService.getCustomerWithHighestSalary();
                    if (highestSalaryCustomer != null) {
                        System.out.println("Customer with highest salary: " + highestSalaryCustomer);
                    } else {
                        System.out.println("No customer data available.");
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}
