package com.example.demo.service;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.stereotype.Service;

import com.example.demo.MQService.AyMoodProducer;
import com.example.demo.data.JpaAyMoodRepository;
import com.example.demo.model.AyMood;

@Service
public class AymoodServiceImpl implements AyMoodService {

	@Resource
	private JpaAyMoodRepository repository;

	@Override
	public AyMood save(AyMood mood) {
		// TODO Auto-generated method stub
		return repository.save(mood);
	}

	
	private static Destination destination=new ActiveMQQueue("ayMood.asyn.queue.save");
	@Resource
	private AyMoodProducer ayMoodProducer;
	@Override
	public String aysnSave(AyMood mood) {
		// TODO Auto-generated method stub
		ayMoodProducer.sendAyMoodMessage(destination, mood);
		return "success";
	}
	
	
}
