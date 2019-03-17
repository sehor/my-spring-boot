package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.error.BusinessException;
import com.example.demo.model.AyUser;
import com.example.demo.service.AyUserService;

@Controller
@RequestMapping("/ayUser")
public class AyUserController {

	@Resource
	private AyUserService service;

	@RequestMapping("/test")
	public String ayUserList(Model model) {

		List<AyUser> users = service.findAll();
		model.addAttribute("users", users);
		return "ayUser";
	}

	@RequestMapping("/findAll")
	@ResponseBody
	public Object findAll(Model model) {
		List<AyUser> users = service.findAll();
		if (users == null||users.size() <= 0)
			throw new BusinessException("业务异常！");
		model.addAttribute("users", users);
		return users;
	}
	
	@RequestMapping("/findByNameAndPasswordRetry")
	@ResponseBody
	public AyUser findByNameAndPasswordRetry(String name,String password) {
		
		return service.findByNameAndPassoword(name, password);
		
	}
}
