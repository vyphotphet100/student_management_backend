package com.window_programming_api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.window_programming_api.dto.NotificationDTO;
import com.window_programming_api.service.INotificationService;

@RestController
public class NotificationAPI {

	@Autowired
	private INotificationService notificationService;
	
	@GetMapping("/api/notification")
	public ResponseEntity<NotificationDTO> getNotification() {
		NotificationDTO notificationDto = notificationService.findAll();
		return new ResponseEntity<NotificationDTO>(notificationDto, notificationDto.getHttpStatus());
	}
}
