package com.example.demo.ui;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.backend.ConnectingtoDb;
import com.example.demo.userdata.Accno;
import com.example.demo.userdata.User;

@RestController
public class CreateUi {

	@Autowired
	private ConnectingtoDb con;
	
	  @Autowired private PasswordEncoder pe;
	 
	
	Accno no=new Accno();
	@PostMapping("/add")
	public String createAccount(@RequestBody User user) {
		/* user.generateAccountno(); */
		RestTemplate res=new RestTemplate();
	      no=res.getForObject("http://localhost:1236/accno", Accno.class);
		System.out.println(no.getAccno());
		String num=Long.toString(no.getAccno());
		user.setAccountNumber(num);
		 user.setPassword(pe.encode(user.getPassword()));
		 System.out.println(user.getPassword());
		con.save(user);		
		/* user.setPassword(encoder().encode(user.getPassword())); */
		return  user.getAccountNumber();		
		
	}
	
	
	  @GetMapping("/user") public String user(){ return "user authentication"; }
	 
	
	@GetMapping("/admin")
	public String admin(){
	return "admin authentication";
	}

	/*
	 * @GetMapping("/") public String home(){ return "home authentication"; }
	 */
	
	@GetMapping("/{id}")
	public Optional<User> validate(@PathVariable("id") String id) {
		Optional<User> u=con.findById(id);
	return u;
	}
	
	
	
	
	
	
	  @Bean public PasswordEncoder encoder() { return new BCryptPasswordEncoder();
	  }
	 
}
