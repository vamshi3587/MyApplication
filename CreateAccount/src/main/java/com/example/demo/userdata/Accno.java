package com.example.demo.userdata;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Accno {
private Long accno;



public Accno() {
	super();
	// TODO Auto-generated constructor stub
}



public Accno(Long accno) {
	super();
	this.accno = accno;
}
}
