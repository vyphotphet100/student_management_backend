package com.window_programming_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.window_programming_api.dto.NotificationDTO;
import com.window_programming_api.entity.NotificationEntity;
import com.window_programming_api.repository.NotificationRepository;
import com.window_programming_api.service.INotificationService;

@Service
public class NotificationService extends BaseService implements INotificationService{

	@Autowired 
	private NotificationRepository notificationRepo;
	
	@Override
	public NotificationDTO findAll() {
		NotificationDTO notificationDto = new NotificationDTO();
		List<NotificationEntity> notificationEntities = notificationRepo.findAll();
		
		if (!notificationEntities.isEmpty()) {
			for (NotificationEntity notificationEntity : notificationEntities) 
				notificationDto.getListResult().add(this.converter.toDTO(notificationEntity, NotificationDTO.class));
			
			notificationDto.setMessage("Load notification list successfully.");
			return notificationDto;
		}
		
		return (NotificationDTO)this.ExceptionObject(notificationDto, "There is no notification.");
	}

}
