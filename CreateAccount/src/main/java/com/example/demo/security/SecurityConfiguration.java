/*
 * package com.example.demo.security;
 * 
 * import org.springframework.boot.autoconfigure.EnableAutoConfiguration; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.crypto.password.NoOpPasswordEncoder;
 * 
 * @EnableAutoConfiguration
 * 
 * public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
 * 
 * 
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception { }
 * 
 * 
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * http.authorizeRequests() .antMatchers("/admin").hasRole("ADMIN")
 * .antMatchers("/user").hasAnyRole("ADMIN","USER")
 * .antMatchers("/").permitAll() .and().formLogin(); }
 * 
 * 
 * //authorize for all requests
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * 
 * http.authorizeRequests().anyRequest().permitAll().and().httpBasic();
 * http.csrf().disable(); }
 * 
 * 
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * http.csrf().disable();
 * http.authorizeRequests().antMatchers("/admin").fullyAuthenticated().and().
 * httpBasic(); }
 * 
 * 
 * 
 * @Bean public static NoOpPasswordEncoder passwordencode() { return
 * (NoOpPasswordEncoder)NoOpPasswordEncoder.getInstance(); }
 * 
 * }
 */