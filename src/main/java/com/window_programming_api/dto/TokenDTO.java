package com.window_programming_api.dto;

public class TokenDTO extends AbstractDTO<TokenDTO>{
	
	private String code;
	private Long userId;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
