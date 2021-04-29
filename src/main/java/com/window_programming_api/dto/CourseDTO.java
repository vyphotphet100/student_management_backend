package com.window_programming_api.dto;

import java.util.ArrayList;
import java.util.List;

public class CourseDTO extends AbstractDTO<CourseDTO>{
	private String courseId;
	private String name;
	private Integer period;
	private String description;
	private Integer numberOfCredit;
	private Long fee;
    private List<String> sectionClassIds = new ArrayList<String>();
    
	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPeriod() {
		return period;
	}
	public void setPeriod(Integer period) {
		this.period = period;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getNumberOfCredit() {
		return numberOfCredit;
	}
	public void setNumberOfCredit(Integer numberOfCredit) {
		this.numberOfCredit = numberOfCredit;
	}
	public Long getFee() {
		return fee;
	}
	public void setFee(Long fee) {
		this.fee = fee;
	}
	public List<String> getSectionClassIds() {
		return sectionClassIds;
	}
	public void setSectionClassIds(List<String> sectionClassIds) {
		this.sectionClassIds = sectionClassIds;
	}
	
}
