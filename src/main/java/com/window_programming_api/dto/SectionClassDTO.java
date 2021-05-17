package com.window_programming_api.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SectionClassDTO extends AbstractDTO{
	
	private String id;
	private String name;
	private Date startTime;
	private Date endTime;
	private Integer weekday;
	private String room;
	private Integer period;
	private String description;
    private String courseId;
    private Long lecturerId;
    private List<Long> registerIds = new ArrayList<Long>();
    
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public Long getLecturerId() {
		return lecturerId;
	}
	public void setLecturerId(Long lecturerId) {
		this.lecturerId = lecturerId;
	}
	public List<Long> getRegisterIds() {
		return registerIds;
	}
	public void setRegisterIds(List<Long> registerIds) {
		this.registerIds = registerIds;
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
	public Integer getWeekday() {
		return weekday;
	}
	public void setWeekday(Integer weekday) {
		this.weekday = weekday;
	}
    
}
