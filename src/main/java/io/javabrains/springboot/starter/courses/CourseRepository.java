package io.javabrains.springboot.starter.courses;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Courses, String> {
	
	

}
