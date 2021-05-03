package com.window_programming_api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.window_programming_api.dto.LecturerDTO;
import com.window_programming_api.service.ILecturerService;

@RestController
public class LecturerAPI {

	@Autowired 
	private ILecturerService lecturerService;
	
	@GetMapping("/api/lecturer")
	public ResponseEntity<LecturerDTO> getLecturer() {
		LecturerDTO lecturerDto = lecturerService.findAll();
		return new ResponseEntity<LecturerDTO>(lecturerDto, lecturerDto.getHttpStatus());
	}
}
