package com.example.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.AyRole;

public interface JpaRoleRepository extends JpaRepository<AyRole, String> {

}
