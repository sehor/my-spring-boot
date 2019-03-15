package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.AyUser;
import com.example.demo.service.AyUserService;

@Controller
@RequestMapping("/ayUser")
public class AyUserController {

	@Resource
	private AyUserService service;
	
	@RequestMapping("/test")
	public String ayUserList(Model model) {
		
		 List<AyUser> users=service.findAll();
		 model.addAttribute("users",users);
		 return "ayUser";
	}
}
