package com.window_programming_api.entity;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.ArrayList;
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
@Table(name = "course")
@EntityListeners(AuditingEntityListener.class)
public class CourseEntity{
	
	@Id
	private String id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "period")
	private Integer period;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "number_of_credit")
	private Integer numberOfCredit;
	
	@Column(name = "fee")
	private Long fee;
	
	@OneToMany(mappedBy = "course")
    private List<SectionClassEntity> sectionClasses = new ArrayList<SectionClassEntity>();
	
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public List<SectionClassEntity> getSectionClasses() {
		return sectionClasses;
	}

	public void setSectionClasses(List<SectionClassEntity> sectionClasses) {
		this.sectionClasses = sectionClasses;
	}

}
