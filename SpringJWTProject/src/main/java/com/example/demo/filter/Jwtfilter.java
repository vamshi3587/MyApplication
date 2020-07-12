package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.http.SecurityHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.service.CustomUserDetailService;
import com.example.demo.util.JwtUtil;
@Component
public class Jwtfilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	private CustomUserDetailService customuserdetailservice;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authorizehedder=request.getHeader("Authorization");
		String token = null;
		String userName = null;
		//Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTU5MjE5OTU0NywiaWF0IjoxNTkyMTYzNTQ3fQ.H9f1mVV7_LbcJy9qkPHd-EyjgPzJJZryPzu584nWLkc
		if(authorizehedder !=null && authorizehedder.startsWith("Bearer ")) {
		token=authorizehedder.substring(7);
		userName=jwtutil.extractUsername(token);
	}
		if(userName !=null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userdetails = customuserdetailservice.loadUserByUsername(userName);
			
			if(jwtutil.validateToken(token, userdetails)) {
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken= new UsernamePasswordAuthenticationToken(userdetails, null ,userdetails.getAuthorities());
			usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		filterChain.doFilter(request, response);
	}
}
