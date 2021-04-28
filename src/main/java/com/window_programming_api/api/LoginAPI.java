package com.window_programming_api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.window_programming_api.dto.UserDTO;
import com.window_programming_api.service.ILoginService;

//@CrossOrigin
@RestController
public class LoginAPI {
	@Autowired
	private ILoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<UserDTO> login(@RequestBody UserDTO requestDto) {
		UserDTO userDto = loginService.checkUser(requestDto);
		return new ResponseEntity<UserDTO>(userDto, userDto.getHttpStatus());
	}
	
}
