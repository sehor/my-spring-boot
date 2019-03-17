package com.example.demo;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.data.JpaAyUserRoleRepository;
import com.example.demo.model.AyUserRole;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestData {

	@Resource
	private JpaAyUserRoleRepository repository;
	@Test
	public void testAyUserRole() {
		
		List<AyUserRole> list=repository.findByUserId("1");
		for(AyUserRole userRole:list) {
			
			System.out.println("userId: "+userRole.getUserId() +"  roleId: "+userRole.getRoleId());
		}
		
	}
}
