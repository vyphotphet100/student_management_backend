package com.window_programming_api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.window_programming_api.dto.UserDTO;
import com.window_programming_api.service.IUserService;

//@CrossOrigin
@RestController
public class UserAPI {

	@Autowired
	private IUserService userService;

	@GetMapping("/api/user")
	//@PreAuthorize("hasAnyAuthority('ADMIN')")
	public ResponseEntity<UserDTO> getUsers() {
		UserDTO userDto = userService.findAll();
		return new ResponseEntity<UserDTO>(userDto, userDto.getHttpStatus());
	}
	
	@PostMapping("/api/user")
	public ResponseEntity<UserDTO> postUser(@RequestBody UserDTO requestDto) {
		UserDTO userDto = userService.save(requestDto);
		return new ResponseEntity<UserDTO>(userDto, userDto.getHttpStatus());
	}

}
