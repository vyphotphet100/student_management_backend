package com.window_programming_api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.window_programming_api.dto.EducationTrainingDTO;
import com.window_programming_api.service.IEducationTrainingService;

@RestController
public class EducationTrainingAPI {
	
	@Autowired
	private IEducationTrainingService educationTrainingService;
	
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@GetMapping("/api/education_training")
	public ResponseEntity<EducationTrainingDTO> getEducationTraining() {
		EducationTrainingDTO educationTrainingDto = educationTrainingService.findAll();
		return new ResponseEntity<EducationTrainingDTO>(educationTrainingDto, educationTrainingDto.getHttpStatus());
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@GetMapping("/api/education_training/{username}")
	public ResponseEntity<EducationTrainingDTO> getOneEducationTraining(@PathVariable("username") String username) {
		EducationTrainingDTO educationTrainingDto = educationTrainingService.findOne(username);
		return new ResponseEntity<EducationTrainingDTO>(educationTrainingDto, educationTrainingDto.getHttpStatus());
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@PostMapping("/api/education_training")
	public ResponseEntity<EducationTrainingDTO> postEducationTraining(@RequestBody EducationTrainingDTO educationTrainingDto) {
		educationTrainingDto = educationTrainingService.save(educationTrainingDto);
		return new ResponseEntity<EducationTrainingDTO>(educationTrainingDto, educationTrainingDto.getHttpStatus());
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@PutMapping("/api/education_training")
	public ResponseEntity<EducationTrainingDTO> putEducationTraining(@RequestBody EducationTrainingDTO educationTrainingDto) {
		educationTrainingDto = educationTrainingService.update(educationTrainingDto);
		return new ResponseEntity<EducationTrainingDTO>(educationTrainingDto, educationTrainingDto.getHttpStatus());
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@DeleteMapping("/api/education_training/{username}")
	public ResponseEntity<EducationTrainingDTO> deleteEducationTraining(@PathVariable("username") String username) {
		EducationTrainingDTO educationTrainingDto = educationTrainingService.delete(username);
		return new ResponseEntity<EducationTrainingDTO>(educationTrainingDto, educationTrainingDto.getHttpStatus());
	}

}
