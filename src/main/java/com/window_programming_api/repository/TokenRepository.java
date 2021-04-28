package com.window_programming_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.window_programming_api.entity.TokenEntity;

public interface TokenRepository extends JpaRepository<TokenEntity, Long> {
	TokenEntity findOneByCode(String code);

//	//@Modifying
//	@Query(value = "INSERT INTO token(code) VALUES(?1);", nativeQuery = true)
//	//@Transactional
//	void save(String code);
}
