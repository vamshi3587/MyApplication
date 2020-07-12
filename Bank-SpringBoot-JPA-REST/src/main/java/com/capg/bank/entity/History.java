package com.capg.bank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;

@Entity
@Table(name="Transaction_Spring")
public class History {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int trans_id;
	@Column(length = 20)
	private String operation;
	@Column(length = 20)
	private int acc_id;
	@Column(length = 20)
	private double amount;

	public int getTrans_id() {
		return trans_id;
	}

	public void setTrans_id(int trans_id) {
		this.trans_id = trans_id;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public int getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public History(String operation, int acc_id, double amount) {
		super();
		
		this.operation = operation;
		this.acc_id = acc_id;
		this.amount = amount;
	}

	public History() {
		super();
	}

	@Override
	public String toString() {
		return "History [trans_id=" + trans_id + ", operation=" + operation + ", acc_id=" + acc_id + ", amount="
				+ amount + "]";
	}
	
	
	
}
