package com.window_programming_api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "score")
public class ScoreEntity extends BaseEntity{
	
	@Column(name = "mid_term_score")
	private double midTermScore;

	@Column(name = "end_term_score")
	private double endTermScore;
	
	@ManyToOne 
    @JoinColumn(name = "course_id")
	private CourseEntity course;
	
	@ManyToOne 
    @JoinColumn(name = "student_id")
	private StudentEntity student;
	
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

	
	public CourseEntity getCourse() {
		return course;
	}

	public void setCourse(CourseEntity course) {
		this.course = course;
	}

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}
	
}
