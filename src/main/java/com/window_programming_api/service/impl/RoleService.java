package com.window_programming_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.window_programming_api.dto.RoleDTO;
import com.window_programming_api.entity.RoleEntity;
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

	@Override
	public RoleDTO findAll() {
		RoleDTO roleDto = new RoleDTO();
		
		List<RoleEntity> roleEntities = roleRepo.findAll();
		if (!roleEntities.isEmpty()) {
			for (RoleEntity roleEntity : roleEntities) 
				roleDto.getListResult().add(this.converter.toDTO(roleEntity, RoleDTO.class));
			
			roleDto.setMessage("Load role list successfully.");
			return roleDto;
		}
		
		return (RoleDTO)this.ExceptionObject(roleDto, "There is no role.");
	}

}
