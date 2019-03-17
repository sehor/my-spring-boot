package com.example.demo.MQService;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.example.demo.model.AyMood;

@Service
public class AyMoodProducer {

	 @Resource
	 private JmsTemplate jmsTemplate;
	 
	 public void sendAyMoodMessage(Destination destination,final String message) {
		 
		 	jmsTemplate.send(destination, new MessageCreator() {
				
				@Override
				public Message createMessage(Session session) throws JMSException {
					// TODO Auto-generated method stub
					return session.createTextMessage(message);
				}
			});
	 }
	 
	 public void sendAyMoodMessage(Destination destination,final AyMood aymood) {
		  jmsTemplate.convertAndSend(destination, aymood);
	 }
	
}
