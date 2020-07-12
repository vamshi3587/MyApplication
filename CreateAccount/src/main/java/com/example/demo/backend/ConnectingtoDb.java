package com.example.demo.backend;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.userdata.User;

public interface ConnectingtoDb extends MongoRepository<User , String>{

}

