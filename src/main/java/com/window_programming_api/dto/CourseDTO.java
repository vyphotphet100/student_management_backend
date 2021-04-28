package com.window_programming_api.dto;

import java.util.ArrayList;
import java.util.List;

public class CourseDTO extends AbstractDTO<CourseDTO>{
	private String courseId;
	private String label;
	private Integer period;
	private String description;
	private List<Long> scoreIds = new ArrayList<Long>();
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
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
	public List<Long> getScoreIds() {
		return scoreIds;
	}
	public void setScoreIds(List<Long> scoreIds) {
		this.scoreIds = scoreIds;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	
}
