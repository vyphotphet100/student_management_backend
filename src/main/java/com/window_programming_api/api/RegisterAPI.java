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

import com.window_programming_api.dto.RegisterDTO;
import com.window_programming_api.service.IRegisterService;

@RestController
public class RegisterAPI {
	
	@Autowired
	private IRegisterService registerService;

	@PreAuthorize("hasAnyAuthority('ADMIN', 'STUDENT', 'LECTURER')")
	@GetMapping("/api/register")
	public ResponseEntity<RegisterDTO> getRegister() {
		RegisterDTO registerDto = registerService.findAll();
		return new ResponseEntity<RegisterDTO>(registerDto, registerDto.getHttpStatus());
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'STUDENT', 'LECTURER')")
	@GetMapping("/api/register/{id}")
	public ResponseEntity<RegisterDTO> getOneRegister(@PathVariable("id") Long id) {
		RegisterDTO registerDto = registerService.findOne(id);
		return new ResponseEntity<RegisterDTO>(registerDto, registerDto.getHttpStatus());
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'STUDENT')")
	@PostMapping("/api/register")
	public ResponseEntity<RegisterDTO> postRegister(@RequestBody RegisterDTO registerDto) {
		registerDto = registerService.save(registerDto);
		return new ResponseEntity<RegisterDTO>(registerDto, registerDto.getHttpStatus());
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'LECTURER')")
	@PutMapping("/api/register")
	public ResponseEntity<RegisterDTO> putRegister(@RequestBody RegisterDTO registerDto) {
		registerDto = registerService.update(registerDto);
		return new ResponseEntity<RegisterDTO>(registerDto, registerDto.getHttpStatus());
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'STUDENT')")
	@DeleteMapping("/api/register/{id}")
	public ResponseEntity<RegisterDTO> deleteRegister(@PathVariable("id") Long id) {
		RegisterDTO registerDto = registerService.delete(id);
		return new ResponseEntity<RegisterDTO>(registerDto, registerDto.getHttpStatus());
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'STUDENT')")
	@GetMapping("/api/register/student_id/{studentId}")
	public ResponseEntity<RegisterDTO> getAllByStudentId(@PathVariable("studentId") String studentId) {
		RegisterDTO registerDto = registerService.findAllByStudentId(studentId);
		return new ResponseEntity<RegisterDTO>(registerDto, registerDto.getHttpStatus());
	}
}
