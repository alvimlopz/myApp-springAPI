package com.alvimCode.myApp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	//@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping //anotação do spring para request mapping
	public Course create(@RequestBody Course course) {
		//System.out.println(course.getName());
		return courseRepository.save(course);
		//return ResponseEntity.status(HttpStatus.CREATED).body(courseRepository.save(course));
	}
	
}
