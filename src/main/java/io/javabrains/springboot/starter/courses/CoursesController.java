package io.javabrains.springboot.starter.courses;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springboot.starter.topics.Topics;

@RestController
public class CoursesController {
	
	@Autowired
	private CourseServices coursesServices;
	
	@RequestMapping("/topics/{id}/courses")
	public List<Courses> getCourses() {
		return coursesServices.getAllCourses();
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Courses getCourse(@PathVariable String id) {
		return coursesServices.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses/{id}")
	public void addCourse(@RequestBody Courses course, @PathVariable String topicId) {
		course.setTopic(new Topics(topicId, "", ""));
		coursesServices.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Courses course, @PathVariable String id, @PathVariable String topicId) {
		course.setTopic(new Topics(topicId, "", ""));
		coursesServices.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		coursesServices.deleteCourse(id);
	}

}
