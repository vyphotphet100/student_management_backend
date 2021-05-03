package com.window_programming_api.dto;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

public class AbstractDTO {
	private Date createdDate;
	private Date modifiedDate;
	private String createdBy;
	private String modifiedBy;
	
	private List<Object> listResult = new ArrayList<Object>(); 
	private String message;
	private HttpStatus httpStatus = HttpStatus.OK;
	private List<Object> listRequest = new ArrayList<Object>();
	private String tokenCode;

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public List<Object> getListResult() {
		return listResult;
	}

	public void setListResult(List<Object> listResult) {
		this.listResult = listResult;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Object> getListRequest() {
		return listRequest;
	}

	public void setListRequest(List<Object> listRequest) {
		this.listRequest = listRequest;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getTokenCode() {
		return tokenCode;
	}

	public void setTokenCode(String tokenCode) {
		this.tokenCode = tokenCode;
	}
	
}
