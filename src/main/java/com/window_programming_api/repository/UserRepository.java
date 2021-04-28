package com.window_programming_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.window_programming_api.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findOneByUserNameAndPassword(String userName, String password);

	@Query(value = "SELECT * FROM user WHERE token_id=?1", nativeQuery = true)
	UserEntity findOneByTokenId(Long id);

	UserEntity findOneByUserName(String userName);

	@Modifying
	@Query(value = "INSERT INTO user(username, password, fullname, token_id) VALUES(?1, ?2, ?3, ?4);", nativeQuery = true)
	@Transactional
	void save(String userName, String password, String fullName, Long tokenId);

}
