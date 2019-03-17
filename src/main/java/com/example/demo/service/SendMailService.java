package com.example.demo.service;

import java.util.List;

import com.example.demo.model.AyUser;

public interface SendMailService {

	boolean sendMail(List<AyUser> userList);
}
