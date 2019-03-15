package com.example.demo.service;

import java.util.List;

import com.example.demo.model.AyUser;

public interface AyUserService {

	List<AyUser> findByKey(String keyword);
	List<AyUser> findAll();
	
}
