package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean
	public CustomerUserService customerUserService() {
		return new CustomerUserService();
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(customerUserService()).passwordEncoder(new BCryptPasswordEncoder());
		
		/*
		 * auth .inMemoryAuthentication() .passwordEncoder(new BCryptPasswordEncoder())
		 * .withUser("user") .password(new
		 * BCryptPasswordEncoder().encode("password")).roles("USER") .and()
		 * .withUser("tom") .password(new
		 * BCryptPasswordEncoder().encode("123")).roles("ADMIN") ;
		 */
		
		//super.configure(auth);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.formLogin()
		.failureUrl("/login?error")
		.defaultSuccessUrl("/ayUser/test")
		.permitAll();
		
		super.configure(http);
	}

	
}
