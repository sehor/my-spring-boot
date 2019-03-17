package com.example.demo.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.AyUserRole;

public interface JpaAyUserRoleRepository extends JpaRepository<AyUserRole, String>{

	List<AyUserRole> findByUserId(String userId);
}
