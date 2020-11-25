package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

@Autowired
private	TopicService topicService; 
@Autowired
private TopicRepository topicRepository;
	
	@GetMapping("/topics")
    public List<Topics> getAllTopics()
    {
		return topicService.getAllTopics();
    }
	
	@PostMapping("/topics")
	public void addTopic(@RequestBody Topics topic)
	{
		 topicService.addTopic(topic);
	}	
	@DeleteMapping("/topics")
	public void deleteAllTopics(Topics topic)
	{
		topicService.deleteTopics(topic);
	}
	@GetMapping("/topics/{id}")
    public Topics getTopic( @PathVariable int id)
    {
		return topicService.getSingleTopic(id);
			
    	
    }
}