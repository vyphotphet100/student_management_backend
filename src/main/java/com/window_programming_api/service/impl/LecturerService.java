package com.window_programming_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.window_programming_api.dto.LecturerDTO;
import com.window_programming_api.entity.LecturerEntity;
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

}
