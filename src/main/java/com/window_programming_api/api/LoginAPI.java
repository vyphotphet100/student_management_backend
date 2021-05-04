package com.window_programming_api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.window_programming_api.dto.AbstractDTO;
import com.window_programming_api.dto.StudentDTO;
import com.window_programming_api.service.ILoginService;

//@CrossOrigin
@RestController
public class LoginAPI {
	@Autowired
	private ILoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody StudentDTO dto) {
		AbstractDTO obj = (AbstractDTO)loginService.login(dto.getUsername(), dto.getPassword());
		return new ResponseEntity<Object>(obj, obj.getHttpStatus());
	}
	
}
