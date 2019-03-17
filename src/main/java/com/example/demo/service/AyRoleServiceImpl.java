package com.example.demo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.data.JpaRoleRepository;
import com.example.demo.model.AyRole;

@Service
public class AyRoleServiceImpl implements AyRoleService{
@Resource
  private JpaRoleRepository repository;
	@Override
	public AyRole findRole(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

}
