package com.example.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.AyMood;

public interface JpaAyMoodRepository extends JpaRepository<AyMood, String> {

}
