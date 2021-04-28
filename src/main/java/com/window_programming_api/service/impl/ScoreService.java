package com.window_programming_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.window_programming_api.dto.ScoreDTO;
import com.window_programming_api.entity.ScoreEntity;
import com.window_programming_api.repository.ScoreRepository;
import com.window_programming_api.service.IScoreService;

@Service
public class ScoreService extends BaseService implements IScoreService{

	@Autowired
	private ScoreRepository scoreRepo;
	
	@Override
	public ScoreDTO findAll() {
		ScoreDTO resDto = new ScoreDTO();
		List<ScoreEntity> scoreEntities = scoreRepo.findAll();
		for (int i=0; i<scoreEntities.size(); i++) 
			resDto.getListResult().add(this.converter.toDTO(scoreEntities.get(i), ScoreDTO.class));
		
		if (!resDto.getListResult().isEmpty())
			return resDto;
		
		return (ScoreDTO)this.ExceptionObject(resDto, "Score is empty.");
	}

	@Override
	public ScoreDTO save(ScoreDTO scoreDto) {
		if (scoreRepo.findOneByCourseCourseIdAndStudentStudentId(scoreDto.getCourseId(), scoreDto.getStudentId()) != null)
			return (ScoreDTO)this.ExceptionObject(scoreDto, "This score exists already.");
		
		ScoreEntity scoreEntity = this.converter.toEntity(scoreDto, ScoreEntity.class);
		ScoreDTO resDto = this.converter.toDTO(scoreRepo.save(scoreEntity), ScoreDTO.class);
		resDto.setMessage("Add score succesfully.");
		return resDto;
	}

	@Override
	public ScoreDTO update(ScoreDTO scoreDto) {
		if (scoreRepo.findOneByCourseCourseIdAndStudentStudentId(scoreDto.getCourseId(), scoreDto.getStudentId()) == null)
			return (ScoreDTO)this.ExceptionObject(scoreDto, "This score does not exist.");
		
		ScoreEntity scoreEntity = this.converter.toEntity(scoreDto, ScoreEntity.class);
		ScoreDTO resDto = this.converter.toDTO(scoreRepo.save(scoreEntity), ScoreDTO.class);
		resDto.setMessage("Update score succesfully.");
		return resDto;
	}

	@Override
	public ScoreDTO delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
