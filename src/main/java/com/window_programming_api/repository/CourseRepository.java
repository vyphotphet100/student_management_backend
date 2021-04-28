package com.window_programming_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.window_programming_api.entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, String>{
	
	CourseEntity findAllByLabel(String label);
	CourseEntity findOneByCourseId(String courseId);

}
