package com.window_programming_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.window_programming_api.dto.UserDTO;
import com.window_programming_api.entity.TokenEntity;
import com.window_programming_api.entity.UserEntity;
import com.window_programming_api.jwtutils.JwtUtil;
import com.window_programming_api.repository.TokenRepository;
import com.window_programming_api.repository.UserRepository;
import com.window_programming_api.service.IUserService;

@Service
public class UserService extends BaseService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TokenRepository tokenRepo;

	@Override
	public UserDTO findOneByUserNameAndPassword(String username, String password) {
		UserEntity userEntity = userRepository.findOneByUserNameAndPassword(username, password);
		if (userEntity != null)
			return converter.toDTO(userEntity, UserDTO.class);
		
		return (UserDTO)this.ExceptionObject(new UserDTO(), "User does not exist.");
	}

	@Override
	public UserDTO findOneByTokenCode(String tokenCode) {
		TokenEntity tokenEntity = tokenRepo.findOneByCode(tokenCode);
		if (tokenEntity == null)
			return (UserDTO)this.ExceptionObject(new UserDTO(), "User does not exist.");
		
		return converter.toDTO(tokenEntity.getUser(), UserDTO.class);
	}

	@Override
	public UserDTO findAll() {
		UserDTO userDto = new UserDTO();
		List<UserEntity> lUserEntity = userRepository.findAll();
		for (int i = 0; i < lUserEntity.size(); i++)
			userDto.getListResult().add(converter.toDTO(lUserEntity.get(i), UserDTO.class));

		if (!userDto.getListResult().isEmpty()) {
			userDto.setMessage("Load list of users successfully.");
		}
		
		return (UserDTO)this.ExceptionObject(userDto, "There is no user.");
	}

	@Override
	public UserDTO findOneByUserName(String userName) {
		UserDTO userDto = converter.toDTO(userRepository.findOneByUserName(userName), UserDTO.class);
		if (userDto == null)
			return (UserDTO)this.ExceptionObject(new UserDTO(), "User does not exist.");
		return userDto;
	}

	@Override
	public UserDTO save(UserDTO userDto) {
		if (userRepository.findOneByUserName(userDto.getUserName()) == null) {
			// create token
			TokenEntity tokenEntity = new TokenEntity();
			tokenEntity.setCode(userDto.getUserName());
			tokenEntity = tokenRepo.save(tokenEntity);
			tokenEntity.setCode(JwtUtil.generateToken(userDto));

			// create user
			UserEntity userEntity = converter.toEntity(userDto, UserEntity.class);
			userEntity.setToken(tokenEntity);
			userEntity = userRepository.save(userEntity);
			
			userDto = converter.toDTO(userEntity, UserDTO.class);
			userDto.setMessage("Add user successfully.");
			return userDto;
		}

		return (UserDTO)this.ExceptionObject(new UserDTO(), "Username exists already.");
	}

	@Override
	public UserDTO update(UserDTO userDto) {
		if (userRepository.findOneByUserName(userDto.getUserName()) != null) {
			UserEntity userEntity = converter.toEntity(userDto, UserEntity.class);
			userDto.setMessage("Update user successfully.");
			return converter.toDTO(userRepository.save(userEntity), UserDTO.class);
		}

		return (UserDTO)this.ExceptionObject(new UserDTO(), "Username does not exist.");
	}

}
