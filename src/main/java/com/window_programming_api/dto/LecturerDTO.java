package com.window_programming_api.dto;

import java.util.Date;
import java.util.List;

public class LecturerDTO extends AbstractDTO<LecturerDTO>{

	private String username;
	private String password;
	private String fullname;
	private Date birthday;
	private String phoneNumber;
	private String address;
    private List<String> sectionClassIds;
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
	public List<String> getSectionClassIds() {
		return sectionClassIds;
	}
	public void setSectionClassIds(List<String> sectionClassIds) {
		this.sectionClassIds = sectionClassIds;
	}
    
    
}
