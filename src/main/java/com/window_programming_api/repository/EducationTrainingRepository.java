package com.window_programming_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.window_programming_api.entity.EducationTrainingEntity;

public interface EducationTrainingRepository extends JpaRepository<EducationTrainingEntity, String>{

	EducationTrainingEntity findOneByUsernameAndPassword(String username, String password);
	EducationTrainingEntity findOneByTokenCode(String token);
}
