package com.window_programming_api.service;

import com.window_programming_api.dto.ScoreDTO;

public interface IScoreService extends IBaseService{
	
	ScoreDTO findAll();
	ScoreDTO save(ScoreDTO scoreDto);
	ScoreDTO update(ScoreDTO scoreDto);
	ScoreDTO delete(Long id);
}
