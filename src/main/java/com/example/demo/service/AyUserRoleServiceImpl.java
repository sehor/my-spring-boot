package com.example.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.example.demo.data.JpaAyUserRoleRepository;
import com.example.demo.model.AyUserRole;

@Service
public class AyUserRoleServiceImpl implements AyUserRoleService {

	 @Resource
	 private JpaAyUserRoleRepository repository;

	@Override
	public List<AyUserRole> findByUserId(String userId) {
		// TODO Auto-generated method stub
		
		for(AyUserRole userRole:repository.findByUserId(userId)) {
			System.out.println(userRole.getUserId()+"  "+userRole.getRoleId());
		}
		return repository.findByUserId(userId);
	}
	 
	 
}
