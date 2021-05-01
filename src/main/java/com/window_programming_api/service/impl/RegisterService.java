package com.window_programming_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.window_programming_api.dto.RegisterDTO;
import com.window_programming_api.entity.RegisterEntity;
import com.window_programming_api.repository.RegisterRepository;
import com.window_programming_api.service.IRegisterService;

@Service
public class RegisterService extends BaseService implements IRegisterService{

	@Autowired
	private RegisterRepository registerRepo;
	
	@Override
	public RegisterDTO findAll() {
		RegisterDTO registerDto = new RegisterDTO();
		List<RegisterEntity> registerEntities = registerRepo.findAll();
		
		if (!registerEntities.isEmpty()) {
			for (RegisterEntity registerEntity : registerEntities)
				registerDto.getListResult().add(this.converter.toDTO(registerEntity, RegisterDTO.class));
			
			registerDto.setMessage("Load register list successfully.");
			return registerDto;
		}
		
		return (RegisterDTO)this.ExceptionObject(registerDto, "There is no register.");
	}

}
