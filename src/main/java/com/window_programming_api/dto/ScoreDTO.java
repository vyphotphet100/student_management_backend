package com.window_programming_api.dto;

public class ScoreDTO extends AbstractDTO<ScoreDTO>{
	private double midTermScore;
	private double endTermScore;
	private String courseId;
	private String studentId;
	
	public double getMidTermScore() {
		return midTermScore;
	}
	public void setMidTermScore(double midTermScore) {
		this.midTermScore = midTermScore;
	}
	public double getEndTermScore() {
		return endTermScore;
	}
	public void setEndTermScore(double endTermScore) {
		this.endTermScore = endTermScore;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	
}
