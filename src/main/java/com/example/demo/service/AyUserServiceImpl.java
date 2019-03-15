package com.example.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.data.JpaAyUserRepository;
import com.example.demo.model.AyUser;

@Service
public class AyUserServiceImpl implements AyUserService{

	@Resource
	private JpaAyUserRepository repository;
	
	@Override
	public List<AyUser> findByKey(String keyword) {
		// TODO Auto-generated method stub
		String key="%"+keyword+"%";
		return repository.findByIdLikeOrNameLikeOrPasswordLike(key, key, key);
	}

	@Override
	public List<AyUser> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	

}
