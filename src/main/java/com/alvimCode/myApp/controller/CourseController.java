package com.alvimCode.myApp.controller;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alvimCode.myApp.model.Course;
import com.alvimCode.myApp.repository.CourseRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses")

@Component
@AllArgsConstructor //injeção de dependencia com lombok
public class CourseController {
	
	private final CourseRepository courseRepository;
	
	//subistituindo a anotação de autowired
	public CourseController(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@GetMapping
	public List<Course> list(){
		return courseRepository.findAll();
	}
	
}
