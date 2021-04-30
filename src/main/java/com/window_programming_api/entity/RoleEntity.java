package com.window_programming_api.entity;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "role")
@EntityListeners(AuditingEntityListener.class)
public class RoleEntity {
	
	@Id
	private String code;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "role")
    private List<StudentEntity> students;

	@OneToMany(mappedBy = "role")
    private List<EducationTrainingEntity> educationTrainings;
	
	@OneToMany(mappedBy = "role")
    private List<LecturerEntity> lecturers;
	
	@Column(name = "createddate")
	@CreatedDate
	@Temporal(TIMESTAMP)
	private Date createdDate;
	
	@Column(name = "createdby")
	@CreatedBy
	private String createdBy;
	
	@Column(name = "modifieddate")
	@LastModifiedDate
	@Temporal(TIMESTAMP)
	private Date modifiedDate;
	
	@Column(name = "modifiedby")
	@LastModifiedBy
	private String modifiedBy;

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

	public List<StudentEntity> getStudents() {
		return students;
	}

	public void setStudents(List<StudentEntity> students) {
		this.students = students;
	}

	public List<EducationTrainingEntity> getEducationTrainings() {
		return educationTrainings;
	}

	public void setEducationTrainings(List<EducationTrainingEntity> educationTrainings) {
		this.educationTrainings = educationTrainings;
	}

	public List<LecturerEntity> getLecturers() {
		return lecturers;
	}

	public void setLecturers(List<LecturerEntity> lecturers) {
		this.lecturers = lecturers;
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
	
}
