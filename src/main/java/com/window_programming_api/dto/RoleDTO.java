package com.window_programming_api.dto;

import java.util.ArrayList;
import java.util.List;

public class RoleDTO extends AbstractDTO<RoleDTO>{
	
	private Long id;
	private String name;
	private String code;
	private List<String> studentIds = new ArrayList<String>();
	private List<Long> lecturerIds = new ArrayList<Long>();
	private List<Long> educationTrainingIds = new ArrayList<Long>();
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<String> getStudentIds() {
		return studentIds;
	}
	public void setStudentIds(List<String> studentIds) {
		this.studentIds = studentIds;
	}
	public List<Long> getLecturerIds() {
		return lecturerIds;
	}
	public void setLecturerIds(List<Long> lecturerIds) {
		this.lecturerIds = lecturerIds;
	}
	public List<Long> getEducationTrainingIds() {
		return educationTrainingIds;
	}
	public void setEducationTrainingIds(List<Long> educationTrainingIds) {
		this.educationTrainingIds = educationTrainingIds;
	}

}
