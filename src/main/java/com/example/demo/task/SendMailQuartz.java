package com.example.demo.task;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.example.demo.service.AyUserService;
import com.example.demo.service.SendMailService;

//@Configurable
//@Component
//@EnableScheduling
public class SendMailQuartz {

	@Resource
	private AyUserService userService;
	
	@Resource
	private SendMailService sendMailService;
	
	private static int count=0;
	
	private Logger logger=LogManager.getLogger(SendMailQuartz.class);
			
	//@Scheduled(cron="*/10 * *  * * *")
	public void reportCurrentlyBySchedul() {
	
		//List<AyUser> userList=userService.findAll();
		
		//sendMailService.sendMail(userList);
		count=count+1;
		logger.info("发第"+count+"轮邮件！ "+this);
	}
}
