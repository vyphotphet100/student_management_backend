package com.window_programming_api.service;

import java.util.List;

import com.window_programming_api.dto.CourseDTO;

public interface ICourseService extends IBaseService{
	CourseDTO findAll();
	CourseDTO findOne(String courseId);
	CourseDTO save(CourseDTO courseDto);
	CourseDTO update(CourseDTO courseDto);
	CourseDTO delete(String courseId);
	void delete(List<Object> courseDto);
}
