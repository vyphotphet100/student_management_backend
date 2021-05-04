package com.window_programming_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.window_programming_api.entity.SectionClassEntity;

public interface SectionClassRepository extends JpaRepository<SectionClassEntity, String>{
	SectionClassEntity findOneById(String id);
}
