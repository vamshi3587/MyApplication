package com.capg.bank.controller;

import java.util.List;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.bank.entity.BankBean;
import com.capg.bank.entity.History;
import com.capg.bank.service.BankServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BankRestController {

	@Autowired
	BankServiceImpl bsi;

	@Autowired
	private PasswordEncoder pcod;
	
	@PostMapping("/bank/create")
	public String createAccount(@RequestBody BankBean bean) {
		BCryptPasswordEncoder bc=new BCryptPasswordEncoder();
		bean.setPassword(pcod.encode(bean.getPassword()));
		BankBean b = bsi.addAccount(bean);
		return  "Hello " + b.getCustomer_name() + "\n Your Registration is Successfull\n" + "Your Account Id is "
				+ b.getAccount_id();
	}

	@GetMapping("/login/{id}/{pass}")
	public String login(@PathVariable int id,@PathVariable String pass) {
		
		BankBean b = bsi.getBalance(id);
		//String s=pcod.matches(pass, b.getPassword());
		//if(b.getPassword().equals(s)) {
		
		System.out.println(b.getPassword());
		
if(pcod.matches(pass, b.getPassword())){
		return "sucesss";
		}
		else{
			return "fail";
		}
		//System.out.println(s);
		

	}
	
	@RequestMapping("/logout-sucess")
	public String logout() {
		return "sucess logout";
	}
	
	@GetMapping(value="/bank/showBalance/{id}", produces = "application/text")
	public String showBalance(@PathVariable int id) throws Exception {

		BankBean b = bsi.getBalance(id);

		if (b == null) {
			throw new Exception("Account id Doesnot Exists  please Enter Valid Account Id");
			//throw new Exception();
		}
		return "Hello " + b.getCustomer_name() + "Your Account Balance is " + b.getAmount();
	}

	@GetMapping("/bank/transactions/{id}")
	public List<History> transactions(@PathVariable int id) throws Exception {

		
		if (bsi.printTransactions(id).isEmpty()) {
			throw new Exception("0");
		}

		return bsi.printTransactions(id);
	}

	@GetMapping("/bank/deposit/{id}/{amount}")
	public String deposit(@PathVariable int id, @PathVariable double amount) throws Exception {
		
		
		if(amount > 0) {
		
			BankBean b = bsi.deposit(id, amount);
			if (b == null) {
				
				throw new Exception("Account id Doesnot Exists  please Enter Valid Account Id");
				//throw new Exception();
			}
			else {
				return "Hello " + b.getCustomer_name() + "\n Your Amount is Deposited Succesfully\n"
						+ "Your Current Account Balance is " + b.getAmount();
			}
		}
		else {
			BankBean b = bsi.getBalance(id);
			return "Hello " + b.getCustomer_name() + "\n Your Amount is Deposited UnSuccesfully\n"
					+"Please Enter valid Amount";
		}
	
}

	@GetMapping("/bank/withdraw/{id}/{amount}")
	public String withdraw(@PathVariable int id, @PathVariable double amount) throws Exception {
		BankBean b = bsi.withdraw(id, amount);

		if (b == null) {
		throw new Exception("Account id Doesnot Exists  please Enter Valid Account Id");
			//throw new Exception();
		}
		
		if(b.getAmount()>amount) {
		return "Hello " + b.getCustomer_name() + "\n Your Amount is Withdrawn Succesfully\n"
		+ "Your Current Account Balance is " + b.getAmount();}
		else {
			return "Hello " + b.getCustomer_name() + "\n Your Amount is Withdrawn UnSuccesfully because of low balance\n"
			/* + "Your Current Account Balance is " + b.getAmount() */;}
		}
		

	

	@GetMapping("/bank/fundtransfer/{id1}/{id2}/{amount}")
	public String deposit(@PathVariable int id1, @PathVariable int id2, @PathVariable double amount) throws Exception {
		
		BankBean b = bsi.fundTransfer(id1, id2, amount);
		if (b == null) {
			throw new Exception("Account id Doesnot Exists  please Enter Valid Account Id");
			//throw new Exception();
		}
		
		if(b.getAmount()>amount) {
			return "Hello " + b.getCustomer_name() + "\n Your Amount is Transfer Succesfully\n"
			+ "Your Current Account Balance is " + b.getAmount();}
			else {
				return "Hello " + b.getCustomer_name() + "\n Your Amount is Transfer UnSuccesfully because of low balance\n"
				/* + "Your Current Account Balance is " + b.getAmount() */;}
			}

	@GetMapping("/bank/findall")
	public List<BankBean> getall() {

		List<BankBean> bean = bsi.getAll();
		return bean;
	}

	@ExceptionHandler(Exception.class)
	public String inValid(Exception e) {
		return e.getMessage();
	}
      @Bean

public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
}
