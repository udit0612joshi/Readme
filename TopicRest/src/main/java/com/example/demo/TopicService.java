package com.example.demo;

import java.util.List;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TopicService {
	
	@Autowired
	
  private TopicRepository topicRepository;
	public List<Topics> getAllTopics() {
		
		return topicRepository.findAll();
	}
	public void addTopic(Topics topic) {
		topicRepository.save(topic);
	}
	public void deleteTopics(Topics topic) {
		topicRepository.deleteAll();
		
	}
	public Topics getSingleTopic(int id) {
	
		return topicRepository.findById(id).orElse(null);
	}
	
		
	
	
	
		

	
}
