package com.window_programming_api.service;

import com.window_programming_api.dto.EducationTrainingDTO;

public interface IEducationTrainingService extends IBaseService{
	EducationTrainingDTO findAll();
}

