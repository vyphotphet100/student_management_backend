package com.window_programming_api.service;

import com.window_programming_api.dto.NotificationDTO;

public interface INotificationService extends IBaseService{
	NotificationDTO findAll();
}

