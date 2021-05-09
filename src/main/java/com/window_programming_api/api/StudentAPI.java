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

import com.window_programming_api.dto.StudentDTO;
import com.window_programming_api.service.IStudentService;

@RestController
public class StudentAPI {

	@Autowired
	private IStudentService studentService;

	@PostMapping("/api/student")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public ResponseEntity<StudentDTO> postStudent(@RequestBody StudentDTO requestDto) {
		StudentDTO studentDto = studentService.save(requestDto);
		return new ResponseEntity<StudentDTO>(studentDto, studentDto.getHttpStatus());
	}

	@PutMapping("/api/student")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public ResponseEntity<StudentDTO> putStudent(@RequestBody StudentDTO requestDto) {
		StudentDTO studentDto = studentService.update(requestDto);
		return new ResponseEntity<StudentDTO>(studentDto, studentDto.getHttpStatus());
	}

	@GetMapping("/api/student")
	@PreAuthorize("hasAnyAuthority('ADMIN', 'LECTURER')")
	public ResponseEntity<StudentDTO> getStudent() {
		StudentDTO studentDto = studentService.findAll();
		return new ResponseEntity<StudentDTO>(studentDto, studentDto.getHttpStatus());
	}

	@GetMapping("/api/student/{studentId}")
	@PreAuthorize("hasAnyAuthority('ADMIN', 'LECTURER')")
	// @PreAuthorize("hasAnyAuthority('ADMIN')")
	public ResponseEntity<StudentDTO> getStudentById(@PathVariable("studentId") String studentId) {
		StudentDTO studentDto = studentService.findOne(studentId);
		return new ResponseEntity<StudentDTO>(studentDto, studentDto.getHttpStatus());
	}

	@DeleteMapping("/api/student/{studentId}")
	@PreAuthorize("hasAnyAuthority('ADMIN', 'LECTURER')")
	public ResponseEntity<StudentDTO> deleteStudentById(@PathVariable("studentId") String studentId) {
		StudentDTO studentDto = studentService.delete(studentId);
		return new ResponseEntity<StudentDTO>(studentDto, studentDto.getHttpStatus());
	}

}
