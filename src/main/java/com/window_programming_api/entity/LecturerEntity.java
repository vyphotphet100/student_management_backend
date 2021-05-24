package com.window_programming_api.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "lecturer")
public class LecturerEntity extends BaseEntity {

	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "fullname", columnDefinition = "TEXT")
	private String fullname;
	
	@Column(name = "birthday")
	@Temporal(TemporalType.TIMESTAMP)
	private Date birthday;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "address", columnDefinition = "TEXT")
	private String address;
	
	@OneToMany(mappedBy = "lecturer", fetch = FetchType.EAGER)
    private List<SectionClassEntity> sectionClasses = new ArrayList<SectionClassEntity>();
	
	@Column(name = "token_code", columnDefinition = "TEXT")
	private String tokenCode;
	
	@Column(name = "picture")
	private String picture;
	
	@ManyToOne 
    @JoinColumn(name = "role_code")
    private RoleEntity role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<SectionClassEntity> getSectionClasses() {
		return sectionClasses;
	}

	public void setSectionClasses(List<SectionClassEntity> sectionClasses) {
		this.sectionClasses = sectionClasses;
	}

	public String getTokenCode() {
		return tokenCode;
	}

	public void setTokenCode(String tokenCode) {
		this.tokenCode = tokenCode;
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
}
