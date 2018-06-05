package io.javabrains.springboot.starter.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServices {
	
	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topics> topics = new ArrayList<> (Arrays.asList(
			new Topics("1", "Java", "Study Java"),
			new Topics("2", "Python", "Study Python"),
			new Topics("3", "JavaScript", "Study JavaScript")
			));
	
	public List<Topics> getAllTopics() {
		List<Topics> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topics getTopic(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findOne(id);
	}

	public void addTopic(Topics topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topics topic) {
		topicRepository.save(topic);
		
	}

	public void deleteTopic(String id) {
		topicRepository.delete(id);
		
	}

}
