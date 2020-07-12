package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repositry.UserRepositry;

@Service
public class CustomUserDetailService implements UserDetailsService /* inbilt */{

	@Autowired
	private UserRepositry repositry;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=repositry.findByUserName(username);
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
	}

}
