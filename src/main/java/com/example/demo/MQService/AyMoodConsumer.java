package com.example.demo.MQService;

import javax.annotation.Resource;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.example.demo.model.AyMood;
import com.example.demo.service.AyMoodService;

@Component
public class AyMoodConsumer {
	
	@Resource
	private AyMoodService ayMoodService;

	//@JmsListener(destination="ay_mood_queue")
	public void receiveMessage(String text) {
		
		System.out.println("AyMoodConsumer received the message: "+text);
	}
	
	@JmsListener(destination="ayMood.asyn.queue.save")
	public void saveAyMood(AyMood ayMood) {
		
		ayMoodService.save(ayMood);
		
	}
}
