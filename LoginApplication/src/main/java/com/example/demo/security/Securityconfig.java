package com.example.demo.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Controller;
@Controller
@EnableWebSecurity
public class Securityconfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
				/*
				 * .authorizeRequests().antMatchers("/user").permitAll().and()
				 * .formLogin().loginPage("/user").permitAll() .and()
				 * .logout().invalidateHttpSession(true) .clearAuthentication(true)
				 * .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				 * .logoutSuccessUrl("/logout-sucess")
				 * ..permitAll();
				 */
		.authorizeRequests().antMatchers("/user").permitAll();
		
	}
}
