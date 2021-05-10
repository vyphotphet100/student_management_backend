package com.window_programming_api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.window_programming_api.dto.RoleDTO;
import com.window_programming_api.service.IRoleService;

@RestController
public class RoleAPI {
	
	@Autowired
	private IRoleService roleService;

	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@GetMapping("/api/role")
	public ResponseEntity<RoleDTO> getRole() {
		RoleDTO roleDto = roleService.findAll();
		return new ResponseEntity<RoleDTO>(roleDto, roleDto.getHttpStatus());
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@GetMapping("/api/role/{code}")
	public ResponseEntity<RoleDTO> getOneRole(@PathVariable("code") String code) {
		RoleDTO roleDto = roleService.findOne(code);
		return new ResponseEntity<RoleDTO>(roleDto, roleDto.getHttpStatus());
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@PostMapping("/api/role")
	public ResponseEntity<RoleDTO> postRole(@RequestBody RoleDTO roleDto) {
		roleDto = roleService.save(roleDto);
		return new ResponseEntity<RoleDTO>(roleDto, roleDto.getHttpStatus());
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@PutMapping("/api/role")
	public ResponseEntity<RoleDTO> putRole(@RequestBody RoleDTO roleDto) {
		roleDto = roleService.update(roleDto);
		return new ResponseEntity<RoleDTO>(roleDto, roleDto.getHttpStatus());
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@DeleteMapping("/api/role/{code}")
	public ResponseEntity<RoleDTO> deleteRole(@PathVariable("code") String code) {
		RoleDTO roleDto = roleService.delete(code);
		return new ResponseEntity<RoleDTO>(roleDto, roleDto.getHttpStatus());
	}
}
