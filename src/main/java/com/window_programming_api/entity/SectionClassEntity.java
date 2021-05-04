package com.window_programming_api.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "section_class")
@EntityListeners(AuditingEntityListener.class)
public class SectionClassEntity {
	
	@Id
	private String id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "start_time")
	@Temporal(TemporalType.TIME)
	private Date startTime;
	
	@Column(name = "end_time")
	@Temporal(TemporalType.TIME)
	private Date endTime;
	
	@Column(name = "room")
	private String room;
	
	@ManyToOne 
    @JoinColumn(name = "course_id")
    private CourseEntity course;
	
	@ManyToOne 
    @JoinColumn(name = "lecturer_id")
    private LecturerEntity lecturer;
	
	@OneToMany(mappedBy = "sectionClass")
    private List<RegisterEntity> registers = new ArrayList<RegisterEntity>();
	
	@Column(name = "createddate")
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Column(name = "createdby")
	@CreatedBy
	private String createdBy;
	
	@Column(name = "modifieddate")
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	
	@Column(name = "modifiedby")
	@LastModifiedBy
	private String modifiedBy;

	
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public List<RegisterEntity> getRegisters() {
		return registers;
	}

	public void setRegisters(List<RegisterEntity> registers) {
		this.registers = registers;
	}
}
