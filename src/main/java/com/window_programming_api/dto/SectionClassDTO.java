package com.window_programming_api.dto;

import java.util.Date;
import java.util.List;

import com.window_programming_api.entity.CourseEntity;
import com.window_programming_api.entity.LecturerEntity;

public class SectionClassDTO extends AbstractDTO<SectionClassDTO>{
	
	private String sectionClassId;
	private String name;
	private Date startTime;
	private Date endTime;
	private String room;
    private CourseEntity course;
    private LecturerEntity lecturer;
    private List<Long> registerIds;
    
	public String getSectionClassId() {
		return sectionClassId;
	}
	public void setSectionClassId(String sectionClassId) {
		this.sectionClassId = sectionClassId;
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
	public CourseEntity getCourse() {
		return course;
	}
	public void setCourse(CourseEntity course) {
		this.course = course;
	}
	public LecturerEntity getLecturer() {
		return lecturer;
	}
	public void setLecturer(LecturerEntity lecturer) {
		this.lecturer = lecturer;
	}
	public List<Long> getRegisterIds() {
		return registerIds;
	}
	public void setRegisterIds(List<Long> registerIds) {
		this.registerIds = registerIds;
	}
    
}
