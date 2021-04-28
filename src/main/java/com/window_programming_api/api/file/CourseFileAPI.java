package com.window_programming_api.api.file;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.window_programming_api.dto.CourseDTO;
import com.window_programming_api.file.service.ICourseFileService;

@RestController
public class CourseFileAPI {

	@Autowired
	private ICourseFileService courseFileService;

	@GetMapping("/api/file/course")
	public ResponseEntity<CourseDTO> getCourseFile(@RequestParam("option") String option) {
		CourseDTO courseDto = new CourseDTO();
		if (option == null) {
			courseDto = courseFileService.findAll();
		} else if (option.equals("printCourseList")) {
			courseDto = courseFileService.printCourseList();
		}

		return new ResponseEntity<CourseDTO>(courseDto, courseDto.getHttpStatus());
	}

	@GetMapping(value = "/api/file/course/**")
	public ResponseEntity<Object> getFile(HttpServletRequest request, @RequestParam(value = "option", required = false) String option) {
		if (option == null) {
			String fileName = request.getRequestURI().split("/api/file/course/")[1];
			CourseDTO courseDto = courseFileService.findOneByName(fileName);
			return new ResponseEntity<Object>(courseDto, courseDto.getHttpStatus());
		} else if (option.equals("getFile")) {
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION,
							"attachment;filename=" + request.getRequestURI().split("/api/file/course/")[1])
					.body(courseFileService.getFile(request.getRequestURI()));
		}
		
		return null;
	}
}
