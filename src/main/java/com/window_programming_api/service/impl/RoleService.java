package com.window_programming_api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.window_programming_api.dto.RoleDTO;
import com.window_programming_api.repository.RoleRepository;
import com.window_programming_api.service.IRoleService;

@Service
public class RoleService extends BaseService implements IRoleService{
	
	@Autowired
	private RoleRepository roleRepo;

	@Override
	public RoleDTO findOneByCode(String code) {
		RoleDTO roleDto = converter.toDTO(roleRepo.findOneByCode(code), RoleDTO.class);
		if (roleDto != null)
			return roleDto;
		
		return (RoleDTO)this.ExceptionObject(new RoleDTO(), "Role is null");
	}

}
