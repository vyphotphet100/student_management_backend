package com.window_programming_api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.window_programming_api.dto.TokenDTO;
import com.window_programming_api.entity.TokenEntity;
import com.window_programming_api.repository.TokenRepository;
import com.window_programming_api.service.ITokenService;

@Service
public class TokenService extends BaseService implements ITokenService {

	@Autowired
	private TokenRepository tokenRepo;

	@Override
	public TokenDTO findOneByCode(String code) {
		TokenDTO tokenDto = converter.toDTO(tokenRepo.findOneByCode(code), TokenDTO.class);
		if (tokenDto != null)
			return tokenDto;

		return (TokenDTO) this.ExceptionObject(tokenDto, "There is no token having code=" + code);
	}

	@Override
	public TokenDTO save(TokenDTO tokenDto) {
		if (tokenRepo.findOne(tokenDto.getId()) != null)
			return (TokenDTO) this.ExceptionObject(tokenDto, "Token exists already.");

		TokenEntity tokenEntity = converter.toEntity(tokenDto, TokenEntity.class);
		tokenEntity = tokenRepo.save(tokenEntity);
		return converter.toDTO(tokenEntity, TokenDTO.class);

	}

	@Override
	public TokenDTO update(TokenDTO tokenDto) {
		if (tokenRepo.findOne(tokenDto.getId()) == null)
			return (TokenDTO) this.ExceptionObject(tokenDto, "Token does not exist.");

		TokenEntity tokenEntity = converter.toEntity(tokenDto, TokenEntity.class);
		tokenEntity = tokenRepo.save(tokenEntity);
		return converter.toDTO(tokenEntity, TokenDTO.class);
	}

}
