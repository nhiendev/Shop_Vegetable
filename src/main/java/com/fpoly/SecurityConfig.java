package com.fpoly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseCookie;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.MissingRequestCookieException;

import com.fpoly.Entity.Users;
import com.fpoly.Service.CookieService;
import com.fpoly.Service.LoginService;
import com.fpoly.Service.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserService service;

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(username -> {
			try {
				Users us = service.findByUsername(username);
				String password = us.getPassword();
				Integer role = us.getAdmin();
				return User.withUsername(username).password(password).roles(String.valueOf(role)).build();
			} catch (Exception e) {
				throw new UsernameNotFoundException(username + " not Found !");
			}
		});
	}

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable(); }
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		http.authorizeHttpRequests().anyRequest().permitAll();
//		.antMatchers("/home", "/about", "/blog","/sign-up","/login").permitAll() // all role truy cap
//		.antMatchers("/admin/**").hasRole("0")
//		.antMatchers("cart").hasRole("1")
//		.antMatchers("/checkout").hasAnyAuthority("0", "1");
		
		http.formLogin().loginPage("/login")
		.loginProcessingUrl("/login/success")
		.defaultSuccessUrl("/home", false)
		.failureUrl("/login");

		// dang nhap roi nhung vao url khong dung
		http.exceptionHandling().accessDeniedPage("/not-found");
		
		http.logout()
		.deleteCookies("uName").deleteCookies("uPass")
		.logoutUrl("/logout")
		.logoutSuccessUrl("/login")
		.addLogoutHandler(new SecurityContextLogoutHandler())
		.clearAuthentication(true);
		

	}

	@Bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
//
//	// Cho phép truy xuất API từ bên ngoài (domain khac)	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/rsx/**", "/api/**");
	}

}
