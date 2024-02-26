package com.alvimCode.myApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alvimCode.myApp.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
