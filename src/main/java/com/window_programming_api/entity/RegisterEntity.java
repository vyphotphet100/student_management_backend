package com.window_programming_api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "register")
public class RegisterEntity extends BaseEntity{
	
	@ManyToOne 
    @JoinColumn(name = "student_id")
    private StudentEntity student;
	
	@ManyToOne 
    @JoinColumn(name = "section_class_id")
    private SectionClassEntity sectionClass;
	
	@Column(name = "midterm_mark")
	private double midTermMark;
	
	@Column(name = "endterm_mark")
	private double endTermMark;
	
	@Column(name = "description")
	private String description;

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}

	public SectionClassEntity getSectionClass() {
		return sectionClass;
	}

	public void setSectionClass(SectionClassEntity sectionClass) {
		this.sectionClass = sectionClass;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
