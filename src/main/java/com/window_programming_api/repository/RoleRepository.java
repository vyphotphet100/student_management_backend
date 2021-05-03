package com.window_programming_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.window_programming_api.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, String> {
	RoleEntity findOne(String code);
	
}
