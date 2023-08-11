package com.fpoly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fpoly.Service.UserService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	UserService service;
	
//	@Autowired
//	 BCryptPasswordEncoder pe;
//	
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(username ->{
//			try {
//				Users us = service.findByUsername(username);
//				String password = pe.encode(us.getPassword());
//				Integer role = us.getAdmin();
//				return User.withUsername(username).password(password).roles(String.valueOf(role)).build();
//			} catch (Exception e) {
//				 throw new UsernameNotFoundException(username + " not Found !");
//			}
//		});
//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable();
//		
//		http.authorizeHttpRequests()
//		.antMatchers("/checkout/**").authenticated()
//		.antMatchers("/admin/**").hasAnyRole("0")
//		.anyRequest().permitAll();
//		
//		http.formLogin()
//		.loginPage("/login")
//		.loginProcessingUrl("/login")
//		.defaultSuccessUrl(null);
//	}
}
