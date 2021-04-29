package com.window_programming_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.window_programming_api.entity.RegisterEntity;

public interface RegisterRepository extends JpaRepository<RegisterEntity, Long>{
	RegisterEntity findOneByStudentIdAndSectionClassId(String studentId, String sectionClassId);
}
