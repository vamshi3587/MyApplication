package com.example.demo.repositry;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.User;

public interface UserRepositry extends MongoRepository<User, Integer>{

	User findByUserName(String username);

	
}
