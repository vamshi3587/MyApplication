package com.example.demo.Reposatry;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.POJO.Book;

public interface Repo extends MongoRepository< Book, Integer>{

}
