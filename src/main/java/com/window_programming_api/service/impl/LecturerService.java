package com.window_programming_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.window_programming_api.dto.LecturerDTO;
import com.window_programming_api.entity.LecturerEntity;
import com.window_programming_api.jwtutils.JwtUtil;
import com.window_programming_api.repository.LecturerRepository;
import com.window_programming_api.service.ILecturerService;

@Service
public class LecturerService extends BaseService implements ILecturerService{
	
	@Autowired
	private LecturerRepository lecturerRepo;

	@Override
	public LecturerDTO findAll() {
		LecturerDTO lecturerDto = new LecturerDTO();
		List<LecturerEntity> lecturerEntities = lecturerRepo.findAll();
		
		if (!lecturerEntities.isEmpty()) {
			for (LecturerEntity lecturerEntity : lecturerEntities)
				lecturerDto.getListResult().add(this.converter.toDTO(lecturerEntity, LecturerDTO.class));
			
			lecturerDto.setMessage("Load lecturer list successfully.");
			return lecturerDto;
		}
		
		return (LecturerDTO)this.ExceptionObject(lecturerDto, "There is no lecturer.");
	}

	@Override
	public LecturerDTO findOneByTokenCode(String token) {
		LecturerDTO lecturerDto = new LecturerDTO();
		LecturerEntity lecturerEntity = lecturerRepo.findOneByTokenCode(token);
		
		if (lecturerEntity != null) {
			lecturerDto = this.converter.toDTO(lecturerEntity, LecturerDTO.class);
			lecturerDto.setMessage("Load lecturer successfully.");
			return lecturerDto;
		}
		
		return (LecturerDTO)this.ExceptionObject(lecturerDto, "Cannot find lecturer.");
	}

	@Override
	public LecturerDTO findOne(Long id) {
		LecturerDTO lecturerDto = new LecturerDTO();
		LecturerEntity lecturerEntity = lecturerRepo.findOne(id);
		
		if (lecturerEntity != null) {
			lecturerDto = this.converter.toDTO(lecturerEntity, LecturerDTO.class);
			lecturerDto.setMessage("Get lecturer having id = " + id + " successfully.");
			return lecturerDto;
		}
		
		return (LecturerDTO) this.ExceptionObject(lecturerDto, "This lecturer does not exist.");
	}

	@Override
	public LecturerDTO save(LecturerDTO lecturerDto) {
		LecturerEntity lecturerEntity = lecturerRepo.findOneByUsername(lecturerDto.getUsername());
		
		if (lecturerEntity == null) {
			String token = JwtUtil.generateToken(lecturerDto);
			lecturerDto.setTokenCode(token);
			lecturerDto.setRoleCode("LECTURER");
			
			lecturerEntity = lecturerRepo.save((LecturerEntity)this.converter.toEntity(lecturerDto, LecturerEntity.class));
			lecturerDto = this.converter.toDTO(lecturerEntity, LecturerDTO.class);
			lecturerDto.setMessage("Save lecturer successfully.");
			return lecturerDto;
		}
		
		return (LecturerDTO)this.ExceptionObject(lecturerDto, "Username exists already.");
	}

}
