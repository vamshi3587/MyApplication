package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.POJO.Book;
import com.example.demo.Reposatry.Repo;

@RestController
public class Resource {

	@Autowired
	private Repo repositry;
	
	@PostMapping("/add")
	public String Add(@RequestBody Book book) {
	
		repositry.save(book);
		
		return "sucess" + book.getId();
	}
	
	@GetMapping("/findall")
	public  List<Book> getbook() {
		return repositry.findAll();
	}
	
	@GetMapping("/update/{id}")
	public Optional<Book> update(@PathVariable  int id){
		return repositry.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		repositry.deleteById(id);
		return "deleted"+id;	}
}
