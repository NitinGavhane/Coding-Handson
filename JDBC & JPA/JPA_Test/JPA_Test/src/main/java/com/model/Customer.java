package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private double balance;

	@OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<CreatedOrder> createdOrders = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Set<CreatedOrder> getCreatedOrders() {
		return createdOrders;
	}

	public void setCreatedOrders(Set<CreatedOrder> createdOrders) {
		this.createdOrders = createdOrders;
	}

	public Customer(Long id, String name, double balance, Set<CreatedOrder> createdOrders) {
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.createdOrders = createdOrders;
	}

	public Customer() {
	}

	@Override
	public String toString() {
		// Avoid triggering associations or recursive toString() calls
		return "Customer{" + "id=" + id + ", name='" + name + '\'' + ", balance=" + balance + '}';
	}

}
