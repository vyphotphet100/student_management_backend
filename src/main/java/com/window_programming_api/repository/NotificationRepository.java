package com.window_programming_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.window_programming_api.entity.NotificationEntity;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Long>{

}
