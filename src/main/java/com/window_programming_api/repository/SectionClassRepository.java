package com.window_programming_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.window_programming_api.entity.SectionClassEntity;

public interface SectionClassRepository extends JpaRepository<SectionClassEntity, String>{
	List<SectionClassEntity> findAllByLecturerId(Long lecturerId);
}
