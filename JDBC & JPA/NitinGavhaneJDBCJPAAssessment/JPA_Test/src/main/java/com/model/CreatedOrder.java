package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CreatedOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private long creationDateTimeMillis;

	private double amount;

	private String productInfo;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer createdBy;

	public CreatedOrder(Long id, Customer createdBy, long creationDateTimeMillis, double amount, String productInfo) {
		super();
		this.id = id;
		this.createdBy = createdBy;
		this.creationDateTimeMillis = creationDateTimeMillis;
		this.amount = amount;
		this.productInfo = productInfo;
	}

	public CreatedOrder() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Customer createdBy) {
		this.createdBy = createdBy;
	}

	public long getCreationDateTimeMillis() {
		return creationDateTimeMillis;
	}

	public void setCreationDateTimeMillis(long creationDateTimeMillis) {
		this.creationDateTimeMillis = creationDateTimeMillis;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

	@Override
	public String toString() {
		return "CreatedOrder [id=" + id + ", createdBy=" + createdBy + ", creationDateTimeMillis="
				+ creationDateTimeMillis + ", amount=" + amount + ", productInfo=" + productInfo + "]";
	}

}
