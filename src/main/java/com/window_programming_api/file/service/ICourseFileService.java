package com.window_programming_api.file.service;

import com.window_programming_api.dto.CourseDTO;
import com.window_programming_api.dto.MyFileDTO;

public interface ICourseFileService extends IBaseFileService{
	CourseDTO findAll();
	CourseDTO findOneByName(String fileName);
	CourseDTO save(MyFileDTO fileDto);
	CourseDTO update(MyFileDTO fileDto);
	CourseDTO delete(String fileName);
	CourseDTO printCourseList();
	
	byte[] getFile(String source);
}
