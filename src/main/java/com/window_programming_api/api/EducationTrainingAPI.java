package com.window_programming_api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.window_programming_api.dto.EducationTrainingDTO;
import com.window_programming_api.service.IEducationTrainingService;

@RestController
public class EducationTrainingAPI {
	
	@Autowired
	private IEducationTrainingService educationTrainingService;
	
	@GetMapping("/api/education_training")
	public ResponseEntity<EducationTrainingDTO> getEducationTraining() {
		EducationTrainingDTO educationTrainingDto = educationTrainingService.findAll();
		return new ResponseEntity<EducationTrainingDTO>(educationTrainingDto, educationTrainingDto.getHttpStatus());
	}

}
