package com.example.demo.Exception;

import lombok.ToString;

@ToString
public class LoginException extends Exception {
	private String msg;

	public LoginException(String msg) {
		super();
		this.msg = msg;
	}
	

}
