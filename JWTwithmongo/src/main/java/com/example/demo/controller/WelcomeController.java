package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AuthRequest;
import com.example.demo.util.JwtUtil;

@RestController
public class WelcomeController {

	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	private AuthenticationManager authenticationManager;
	@GetMapping("/")
	public String welcome() {
		return "Welcome";
	}
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authrequest) throws Exception {
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authrequest.getUserName(),authrequest.getPassword()));
		}
		catch (Exception e) {
		throw new Exception("invallid username/password");
		}
		return jwtutil.generateToken(authrequest.getUserName());
		
	
	}
}
