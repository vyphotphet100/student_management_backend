package com.window_programming_api.service;

import com.window_programming_api.dto.TokenDTO;

public interface ITokenService extends IBaseService{
	TokenDTO findOneByCode(String code);
	TokenDTO save(TokenDTO tokenDto);
	TokenDTO update(TokenDTO tokenDto);
}
