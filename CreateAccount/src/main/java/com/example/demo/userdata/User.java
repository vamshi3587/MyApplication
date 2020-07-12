package com.example.demo.userdata;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Document(collection = "CreateAccount")
public class User {

	@Id
	private String userName;
	private String password;
	private String mobileNumber;
	private String emailId;
	private String accountNumber;
	
	 
}
