package com.capg.bank.dao;

import java.util.List;

import com.capg.bank.entity.BankBean;
import com.capg.bank.entity.History;

public interface IBankDao {
	
	
	public BankBean addAccount(BankBean bean);
	
	public BankBean getBalance(int id);
	
	public BankBean deposit(int id, double amount);
	
	public BankBean withdraw(int id, double amount);
	
	public  BankBean fundTransfer(int id1, int id2, double amount);
	
	public List<History> printTransactions(int id);

	public List<BankBean> getAll();
	

}
