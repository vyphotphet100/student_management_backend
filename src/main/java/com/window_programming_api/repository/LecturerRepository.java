package com.window_programming_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.window_programming_api.entity.LecturerEntity;

public interface LecturerRepository extends JpaRepository<LecturerEntity, Long>{

}
