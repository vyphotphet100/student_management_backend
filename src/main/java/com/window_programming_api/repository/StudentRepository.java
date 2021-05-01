package com.window_programming_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.window_programming_api.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, String>{
	StudentEntity findOneById(String studentId);
	StudentEntity findOneByUsernameAndPassword(String username, String password);
	StudentEntity findOneByTokenCode(String token);
}
