package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.User;
import com.example.demo.repositry.UserRepositry;

@SpringBootApplication
public class SpringJwtProjectApplication {
	
	@Autowired
	private UserRepositry repositry;

	@PostConstruct  //it acts as init method
	public void initUsers() {
		List<User> users=Stream.of(
      new User(101, "user1", "password1", "vam1@syf.com"),
      new User(102, "user2", "password2", "vam2@syf.com"),
      new User(103, "user3", "password3", "vam3@syf.com"),
      new User(104, "user4", "password4", "vam4@syf.com")
				).collect(Collectors.toList());
		repositry.saveAll(users);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringJwtProjectApplication.class, args);
	}

}
