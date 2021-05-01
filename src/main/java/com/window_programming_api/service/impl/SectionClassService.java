package com.window_programming_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.window_programming_api.dto.SectionClassDTO;
import com.window_programming_api.entity.SectionClassEntity;
import com.window_programming_api.repository.SectionClassRepository;
import com.window_programming_api.service.ISectionClassService;

@Service
public class SectionClassService extends BaseService implements ISectionClassService{

	@Autowired
	private SectionClassRepository sectionClassRepo;
	
	@Override
	public SectionClassDTO findAll() {
		SectionClassDTO sectionClassDto = new SectionClassDTO();
		List<SectionClassEntity> sectionClassEntities = sectionClassRepo.findAll();
		
		if (!sectionClassEntities.isEmpty()) {
			for (SectionClassEntity sectionClassEntity : sectionClassEntities)
				sectionClassDto.getListResult().add(this.converter.toDTO(sectionClassEntity, SectionClassDTO.class));
			
			sectionClassDto.setMessage("Load section class list successfully.");
			return sectionClassDto;
		}
		
		return (SectionClassDTO)this.ExceptionObject(sectionClassDto, "There is no section class.");
	}

}
