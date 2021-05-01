package com.window_programming_api.service;

import com.window_programming_api.dto.LecturerDTO;

public interface ILecturerService extends IBaseService{
	LecturerDTO findAll();
	LecturerDTO findOneByTokenCode(String token);
}

