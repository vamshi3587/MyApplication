package com.example.demo.POJO;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "Book")
public class Book {
	@Id
private int id;
private String name;
private String auth;

}
