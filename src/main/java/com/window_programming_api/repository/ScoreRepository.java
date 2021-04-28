package com.window_programming_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.window_programming_api.entity.ScoreEntity;

public interface ScoreRepository extends JpaRepository<ScoreEntity, Long>{
	ScoreEntity findOneByCourseCourseIdAndStudentStudentId(String courseId, String studentId);
}
