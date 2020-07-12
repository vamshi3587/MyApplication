package com.example.demo.UI;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.data.LoginUserdata;

@RestController
public class LoginUI {
	
	  @Autowired private PasswordEncoder pe;

	@PostMapping("/{uid}/{password}")
	public String validate(@PathVariable("uid") String uid ,@PathVariable("password") String pass) throws LoginException
	{
		System.out.println("hit");
		RestTemplate res=new RestTemplate();
		/*
		 * LoginUserdata ud=res.exchange("http://localhost:1234"+uid, HttpMethod.GET,
		 * LoginUserdata.class)
		 */
		System.out.println("going");
		
		LoginUserdata ud=res.getForObject("http://localhost:6001/"+uid, LoginUserdata.class);
		
		System.out.println(ud.getAccountNumber());
		
		System.out.println(ud.getPassword());
		System.out.println(ud.getUserName());
		
		if(pe.matches(pass, ud.getPassword())) {
			return "Login Sucess";
		}
		
		else {
		return "fail";
		}
		
	}
	
	@RequestMapping("/user")
	public String user() {
		return "user";
	}
	 @Bean public PasswordEncoder encoder() { return new BCryptPasswordEncoder();
	  }
}
