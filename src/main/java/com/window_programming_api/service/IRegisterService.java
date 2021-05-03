package com.window_programming_api.service;

import com.window_programming_api.dto.RegisterDTO;

public interface IRegisterService extends IBaseService{
	RegisterDTO findAll();
	RegisterDTO findOne(Long id);
	RegisterDTO save(RegisterDTO registerDto);
	RegisterDTO update(RegisterDTO registerDto);
	RegisterDTO delete(Long id);
}

