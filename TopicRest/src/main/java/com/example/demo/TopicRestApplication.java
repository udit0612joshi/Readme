package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TopicRestApplication implements CommandLineRunner{

	@Autowired
	private TopicRepository topicRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TopicRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Topics topics = getTopics();
		topicRepository.save(topics);
		
	}
	private Topics getTopics()
	{
		Topics topics = new Topics();
		topics.setId(1);
		topics.setName("Java");
		topics.setDescreption("I am a Java Programmer");
		return topics;
	}

}
