package com.window_programming_api.api.file;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.window_programming_api.dto.MyFileDTO;
import com.window_programming_api.dto.StudentDTO;
import com.window_programming_api.file.service.IStudentFileService;

@RestController
public class StudentFileAPI {
	@Autowired
	private IStudentFileService studentFileService;

	@GetMapping("/api/file/student/**")
	public ResponseEntity<Object> getFile(HttpServletRequest request,
			@RequestParam(value = "option", required = false) String option) {
		if (option == null) {
			StudentDTO studentDto = studentFileService
					.findOneByFileName(request.getRequestURI().split("/api/file/student/")[1]);
			return new ResponseEntity<Object>(studentDto, studentDto.getHttpStatus());
		} else if (option.equals("getFile")) {
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION,
							"attachment;filename=" + request.getRequestURI().split("/api/file/student/")[1])
					.body(studentFileService.getFile(request.getRequestURI()));
		}

		return null;
	}

	@PostMapping(value = "/api/file/student")
	public ResponseEntity<StudentDTO> postFile(@RequestBody MyFileDTO fileDto) {
		StudentDTO studentDto = studentFileService.save(fileDto);
		return new ResponseEntity<StudentDTO>(studentDto, studentDto.getHttpStatus());
	}

	@PutMapping("/api/file/student")
	public ResponseEntity<StudentDTO> updateFile(@RequestBody MyFileDTO fileDto) {
		StudentDTO studentDto = studentFileService.update(fileDto);
		return new ResponseEntity<StudentDTO>(studentDto, studentDto.getHttpStatus());
	}

	@DeleteMapping(value = "/api/file/student")
	public ResponseEntity<StudentDTO> deleteStudent(@RequestBody MyFileDTO fileDto) {
		StudentDTO studentDto = studentFileService.delete(fileDto);
		return new ResponseEntity<StudentDTO>(studentDto, studentDto.getHttpStatus());
	}

}
