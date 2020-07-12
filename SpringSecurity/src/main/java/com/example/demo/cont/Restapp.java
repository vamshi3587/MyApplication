package com.example.demo.cont;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Restapp {

	
	@GetMapping("/hiii")
	public String hii() {
		return "hiii";
	}
	@GetMapping("/login/id")
	public String login() {
		return "Sucess";
		

	}
	
	@RequestMapping("/logout-sucess")
	public String logout() {
		return "sucess logout";
	}
	
}
