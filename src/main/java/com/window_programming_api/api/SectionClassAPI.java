package com.window_programming_api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.window_programming_api.dto.SectionClassDTO;
import com.window_programming_api.service.ISectionClassService;

@RestController
public class SectionClassAPI {
	
	@Autowired
	private ISectionClassService sectionClassService;

	@GetMapping("/api/section_class")
	public ResponseEntity<SectionClassDTO> getSectionClass() {
		SectionClassDTO sectionClassDto = sectionClassService.findAll();
		return new ResponseEntity<SectionClassDTO>(sectionClassDto, sectionClassDto.getHttpStatus());
	}
}
