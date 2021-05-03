package com.window_programming_api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/api/notification/{id}")
	public ResponseEntity<NotificationDTO> getOneNotification(@PathVariable("id") Long id) {
		NotificationDTO notificationDto = notificationService.findOne(id);
		return new ResponseEntity<NotificationDTO>(notificationDto, notificationDto.getHttpStatus());
	}
	
	@PostMapping("/api/notification")
	public ResponseEntity<NotificationDTO> postNotification(@RequestBody NotificationDTO notificationDto) {
		notificationDto = notificationService.save(notificationDto);
		return new ResponseEntity<NotificationDTO>(notificationDto, notificationDto.getHttpStatus());
	}
	
	@PutMapping("/api/notification")
	public ResponseEntity<NotificationDTO> putNotification(@RequestBody NotificationDTO notificationDto) {
		notificationDto = notificationService.update(notificationDto);
		return new ResponseEntity<NotificationDTO>(notificationDto, notificationDto.getHttpStatus());
	}
	
	@DeleteMapping("/api/notification/{id}")
	public ResponseEntity<NotificationDTO> deleteNotification(@PathVariable("id") Long id) {
		NotificationDTO notificationDto = notificationService.delete(id);
		return new ResponseEntity<NotificationDTO>(notificationDto, notificationDto.getHttpStatus());
	}
}
