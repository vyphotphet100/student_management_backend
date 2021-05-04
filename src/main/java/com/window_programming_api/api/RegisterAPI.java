package com.window_programming_api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.window_programming_api.dto.RegisterDTO;
import com.window_programming_api.service.IRegisterService;

@RestController
public class RegisterAPI {
	
	@Autowired
	private IRegisterService registerService;

	@GetMapping("/api/register")
	public ResponseEntity<RegisterDTO> getRegister() {
		RegisterDTO registerDto = registerService.findAll();
		return new ResponseEntity<RegisterDTO>(registerDto, registerDto.getHttpStatus());
	}
}
