package com.example.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRepositry extends JpaRepository<User, Integer>{

	User findByUserName(String username);

	
}
