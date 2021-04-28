package com.window_programming_api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.window_programming_api.dto.ScoreDTO;
import com.window_programming_api.service.IScoreService;

@RestController
public class ScoreAPI {
	
	@Autowired
	private IScoreService scoreService;
	
	@GetMapping("/api/score")
	public ResponseEntity<ScoreDTO> getScores() {
		ScoreDTO scoreDto = scoreService.findAll();
		return new ResponseEntity<ScoreDTO>(scoreDto, scoreDto.getHttpStatus());
	}
	
	@PostMapping("/api/score")
	public ResponseEntity<ScoreDTO> postScore(@RequestBody ScoreDTO scoreDto) {  
		ScoreDTO resDto = scoreService.save(scoreDto);
		return new ResponseEntity<ScoreDTO>(resDto, resDto.getHttpStatus());
	}

}
