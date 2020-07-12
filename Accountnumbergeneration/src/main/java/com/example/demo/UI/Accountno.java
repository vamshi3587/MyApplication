package com.example.demo.UI;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.accno.Accno;

@RestController
public class Accountno {

	
   Accno ac=new Accno();
	@GetMapping("/accno")
	public String accno()
	{
		ac.setAccno(generate());
		return ac.getAccno();
		
	}
	
	Random r=new Random();
	public String generate() {
		int a=randomnum();
		String a1=Integer.toString(a);
		int b=randomnum();
		String b1=Integer.toString(b);
		int c=randomnum();
		String c1=Integer.toString(c);
		int d=randomnum();
		String d1=Integer.toString(d);
		return a1+b1+c1+d1;
		
	}
	public int randomnum() {
	return (int)(Math.random() * (9999 - 1000 + 1) + 1000);
	}
	
	
	
}