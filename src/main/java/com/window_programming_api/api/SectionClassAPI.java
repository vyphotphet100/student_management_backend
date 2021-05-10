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

import com.window_programming_api.dto.SectionClassDTO;
import com.window_programming_api.service.ISectionClassService;

@RestController
public class SectionClassAPI {
	
	@Autowired
	private ISectionClassService sectionClassService;

	@PreAuthorize("hasAnyAuthority('ADMIN', 'LECTURER', 'STUDENT')")
	@GetMapping("/api/section_class")
	public ResponseEntity<SectionClassDTO> getSectionClass() {
		SectionClassDTO sectionClassDto = sectionClassService.findAll();
		return new ResponseEntity<SectionClassDTO>(sectionClassDto, sectionClassDto.getHttpStatus());
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'LECTURER', 'STUDENT')")
	@GetMapping("/api/section_class/{id}")
	public ResponseEntity<SectionClassDTO> getOneSectionClass(@PathVariable("id") String id) {
		SectionClassDTO sectionClassDto = sectionClassService.findOne(id);
		return new ResponseEntity<SectionClassDTO>(sectionClassDto, sectionClassDto.getHttpStatus());
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@PostMapping("/api/section_class")
	public ResponseEntity<SectionClassDTO> postectionClass(@RequestBody SectionClassDTO sectionClassDto) {
		sectionClassDto = sectionClassService.save(sectionClassDto);
		return new ResponseEntity<SectionClassDTO>(sectionClassDto, sectionClassDto.getHttpStatus());
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@PutMapping("/api/section_class")
	public ResponseEntity<SectionClassDTO> putSectionClass(@RequestBody SectionClassDTO sectionClassDto) {
		sectionClassDto = sectionClassService.update(sectionClassDto);
		return new ResponseEntity<SectionClassDTO>(sectionClassDto, sectionClassDto.getHttpStatus());
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@DeleteMapping("/api/section_class/{id}")
	public ResponseEntity<SectionClassDTO> deleteSectionClass(@PathVariable("id") String id) {
		SectionClassDTO sectionClassDto = sectionClassService.delete(id);
		return new ResponseEntity<SectionClassDTO>(sectionClassDto, sectionClassDto.getHttpStatus());
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'LECTURER')")
	@GetMapping("/api/section_class/lecturer_id/{lecturerId}")
	public ResponseEntity<SectionClassDTO> getAllByLecturerId(@PathVariable("lecturerId") Long lecturerId) {
		SectionClassDTO sectionClassDto = sectionClassService.findAllByLecturerId(lecturerId);
		return new ResponseEntity<SectionClassDTO>(sectionClassDto, sectionClassDto.getHttpStatus());
	}
}
