package com.example.demo.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.AyUser;

public interface JpaAyUserRepository extends JpaRepository<AyUser,String>{
  List<AyUser> findByNameLike(String name);
  List<AyUser> findByIdLikeOrNameLikeOrPasswordLike(
		  String id,String name,String password);
}
