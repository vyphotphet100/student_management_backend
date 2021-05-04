package com.window_programming_api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.window_programming_api.dto.RoleDTO;
import com.window_programming_api.service.IRoleService;

@RestController
public class RoleAPI {
	
	@Autowired
	private IRoleService roleService;

	@GetMapping("/api/role")
	public ResponseEntity<RoleDTO> getRole() {
		RoleDTO roleDto = roleService.findAll();
		return new ResponseEntity<RoleDTO>(roleDto, roleDto.getHttpStatus());
	}
}
