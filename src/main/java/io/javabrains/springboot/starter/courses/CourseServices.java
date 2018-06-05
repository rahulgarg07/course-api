package io.javabrains.springboot.starter.courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServices {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Courses> getAllCourses() {
		List<Courses> courses = new ArrayList<>();
		courseRepository.findAll().forEach(courses::add);
		return courses;
	}
	
	public Courses getCourse(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepository.findOne(id);
	}

	public void addCourse(Courses course) {
		courseRepository.save(course);
	}

	public void updateCourse(Courses course) {
		courseRepository.save(course);
		
	}

	public void deleteCourse(String id) {
		courseRepository.delete(id);
		
	}

}
