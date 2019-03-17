package com.example.demo;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeneralTest {

	@Test
	public void test() {
		
		
		String passwordString=new BCryptPasswordEncoder().encode("tom123");
		System.out.println(passwordString);
	}
}
