package com.window_programming_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.window_programming_api.dto.EducationTrainingDTO;
import com.window_programming_api.entity.EducationTrainingEntity;
import com.window_programming_api.repository.EducationTrainingRepository;
import com.window_programming_api.service.IEducationTrainingService;

@Service
public class EducationTrainingService extends BaseService implements IEducationTrainingService{
	
	@Autowired
	private EducationTrainingRepository educationTrainingRepo;

	@Override
	public EducationTrainingDTO findAll() {
		EducationTrainingDTO educationTrainingDto = new EducationTrainingDTO();
		List<EducationTrainingEntity> educationTrainingEntities = educationTrainingRepo.findAll();
		if (!educationTrainingEntities.isEmpty()) {
			for (int i=0; i<educationTrainingEntities.size(); i++)
				educationTrainingDto.getListResult().add(this.converter.toDTO(educationTrainingEntities.get(i), EducationTrainingDTO.class));
			
			educationTrainingDto.setMessage("Load education training list successfully.");
			return educationTrainingDto;
		}
		
		return (EducationTrainingDTO)this.ExceptionObject(educationTrainingDto, "There is no education training.");
	}

}
