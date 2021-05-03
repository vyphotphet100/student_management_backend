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
	
	@GetMapping("/api/lecturer/{id}")
	public ResponseEntity<LecturerDTO> getOneLecturer(@PathVariable("id") Long id) {
		LecturerDTO lecturerDto = lecturerService.findOne(id);
		return new ResponseEntity<LecturerDTO>(lecturerDto, lecturerDto.getHttpStatus());
	}
	
	@PostMapping("/api/lecturer")
	public ResponseEntity<LecturerDTO> postLecturer(@RequestBody LecturerDTO lecturerDto) {
		lecturerDto = lecturerService.save(lecturerDto);
		return new ResponseEntity<LecturerDTO>(lecturerDto, lecturerDto.getHttpStatus());
	}
	
	@PutMapping("/api/lecturer")
	public ResponseEntity<LecturerDTO> putLecturer(@RequestBody LecturerDTO lecturerDto) {
		lecturerDto = lecturerService.update(lecturerDto);
		return new ResponseEntity<LecturerDTO>(lecturerDto, lecturerDto.getHttpStatus());
	}
	
	@DeleteMapping("/api/lecturer/{id}")
	public ResponseEntity<LecturerDTO> deteleLecturer(@PathVariable("id") Long id) {
		LecturerDTO lecturerDto = lecturerService.delete(id);
		return new ResponseEntity<LecturerDTO>(lecturerDto, lecturerDto.getHttpStatus());
	}
}
