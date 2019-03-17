package com.example.demo.service;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.demo.model.AyUser;

@Service
public class SendMailImpl implements SendMailService{

	
	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
	private String from;
	
	
	private Logger logger=LogManager.getLogger(SendMailImpl.class);
	
	@Override
	public boolean sendMail(List<AyUser> userList) {
		// TODO Auto-generated method stub
		if(userList==null||userList.size()<=0) {
			return false;
		}
		
		
		try {
			MimeMessage mimeMessage=mailSender.createMimeMessage();
			MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMessage);
			messageHelper.setFrom(from);
			messageHelper.setTo("381694645@qq.com");
			messageHelper.setSubject("here some valuable thing!");
			for(AyUser user:userList) {
				
				messageHelper.setText(user.getName()+", here some valuable news:");
				mailSender.send(mimeMessage);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("send mail error and user=%s",userList,e);
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

    
}
