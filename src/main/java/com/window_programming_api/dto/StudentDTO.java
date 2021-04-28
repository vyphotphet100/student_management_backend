package com.window_programming_api.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDTO extends AbstractDTO<StudentDTO>{

	private String studentId;
	private String firstName;
	private String lastName;
	private Date birthday;
	private String gender;
	private String phone;
	private String address;
	private String picture;
	private List<Long> scoreIds = new ArrayList<Long>();
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public List<Long> getScoreIds() {
		return scoreIds;
	}
	public void setScoreIds(List<Long> scoreIds) {
		this.scoreIds = scoreIds;
	}

}
