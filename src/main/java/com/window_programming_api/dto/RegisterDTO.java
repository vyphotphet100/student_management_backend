package com.window_programming_api.dto;

public class RegisterDTO extends AbstractDTO{
	
	private Long id;
    private String studentId;
    private String sectionClassId;
	private double midTermMark;
	private double endTermMark;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getSectionClassId() {
		return sectionClassId;
	}
	public void setSectionClassId(String sectionClassId) {
		this.sectionClassId = sectionClassId;
	}
	public double getMidTermMark() {
		return midTermMark;
	}
	public void setMidTermMark(double midTermMark) {
		this.midTermMark = midTermMark;
	}
	public double getEndTermMark() {
		return endTermMark;
	}
	public void setEndTermMark(double endTermMark) {
		this.endTermMark = endTermMark;
	}
	
}
