package com.capg.bank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="First")
public class BankBean {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int account_id;
	@Column(length = 20)
	private String customer_name;
	@Column(length = 20)
	private double amount;
	@Column(length = 20)
	private String contact_number;
	@Column
private String password;
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	@Override
	public String toString() {
		return "BankBean [account_id=" + account_id + ", customer_name=" + customer_name + ", amount=" + amount
				+ ", contact_number=" + contact_number + ", password=" + password + "]";
	}

	
	
	
}
