package com.window_programming_api.converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.window_programming_api.dto.CourseDTO;
import com.window_programming_api.dto.MyUser;
import com.window_programming_api.dto.RoleDTO;
import com.window_programming_api.dto.StudentDTO;
import com.window_programming_api.dto.TokenDTO;
import com.window_programming_api.dto.UserDTO;
import com.window_programming_api.entity.CourseEntity;
import com.window_programming_api.entity.RoleEntity;
import com.window_programming_api.entity.ScoreEntity;
import com.window_programming_api.entity.StudentEntity;
import com.window_programming_api.entity.TokenEntity;
import com.window_programming_api.entity.UserEntity;
import com.window_programming_api.repository.RoleRepository;
import com.window_programming_api.repository.ScoreRepository;
import com.window_programming_api.repository.TokenRepository;
import com.window_programming_api.repository.UserRepository;

@Component
public class Converter {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private TokenRepository tokenRepo;

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private ScoreRepository scoreRepo;

	@SuppressWarnings("unchecked")
	public <T> T toDTO(Object entity, Class<T> tClass) {
		if (entity == null)
			return null;

		ModelMapper modelMapper = new ModelMapper();
		T resObj = modelMapper.map(entity, tClass);

		if (resObj instanceof TokenDTO) {
			TokenDTO tokenDto = (TokenDTO) resObj;
			TokenEntity tokenEntity = (TokenEntity) entity;

			if (tokenEntity.getUser() != null)
				tokenDto.setUserId(tokenEntity.getUser().getId());

			return (T) tokenDto;

		} else if (resObj instanceof UserDTO) {
			UserDTO userDto = (UserDTO) resObj;
			UserEntity userEntity = (UserEntity) entity;

			// set token code
			if (userEntity.getToken() != null)
				userDto.setTokenCode(userEntity.getToken().getCode());

			// set roleCodes
			if (userEntity.getRoles() != null) {
				List<String> roleCodes = new ArrayList<>();
				for (int i = 0; i < userEntity.getRoles().size(); i++) {
					roleCodes.add(userEntity.getRoles().get(i).getCode());
				}
				userDto.setRoleCodes(roleCodes);
			}

			return (T) userDto;
		} else if (resObj instanceof RoleDTO) {
			RoleDTO roleDto = (RoleDTO) resObj;
			RoleEntity roleEntity = (RoleEntity) entity;

			// set userNames
			if (roleEntity.getUsers() != null) {
				List<String> userNames = new ArrayList<String>();
				for (int i = 0; i < roleEntity.getUsers().size(); i++)
					userNames.add(roleEntity.getUsers().get(i).getUserName());
				roleDto.setUserNames(userNames);
			}

			return (T) roleDto;
		} else if (resObj instanceof CourseDTO) {
			CourseDTO courseDto = (CourseDTO) resObj;
			CourseEntity courseEntity = (CourseEntity) entity;

			// set scores
			if (courseEntity.getScores() != null) {
				List<Long> scores = new ArrayList<Long>();
				for (int i = 0; i < courseEntity.getScores().size(); i++)
					scores.add(courseEntity.getScores().get(i).getId());
				courseDto.setScoreIds(scores);
			}

			return (T) courseDto;
		} else if (resObj instanceof StudentDTO) {
			StudentDTO studentDto = (StudentDTO) resObj;
			StudentEntity studentEntity = (StudentEntity) entity;

			// set scores
			if (studentEntity.getScores() != null) {
				List<Long> scores = new ArrayList<Long>();
				for (int i = 0; i < studentEntity.getScores().size(); i++)
					scores.add(studentEntity.getScores().get(i).getId());
				studentDto.setScoreIds(scores);
			}

			return (T) studentDto;
		}

		return resObj;
	}

	@SuppressWarnings("unchecked")
	public <T> T toEntity(Object dto, Class<T> tClass) {
		if (dto == null)
			return null;

		ModelMapper modelMapper = new ModelMapper();
		T resObj = modelMapper.map(dto, tClass);

		if (resObj instanceof TokenEntity) {
			TokenEntity tokenEntity = (TokenEntity) resObj;
			TokenDTO tokenDto = (TokenDTO) dto;

			// set users
			if (tokenDto.getUserId() != null)
				tokenEntity.setUser(userRepo.findOne(tokenDto.getUserId()));

			return (T) tokenEntity;
		} else if (resObj instanceof UserEntity) {
			UserEntity userEntity = (UserEntity) resObj;
			UserDTO userDto = (UserDTO) dto;

			// set token
			if (userDto.getTokenCode() != null)
				userEntity.setToken(tokenRepo.findOneByCode(userDto.getTokenCode()));

			// set roles
			if (userDto.getRoleCodes() != null) {
				List<RoleEntity> roles = new ArrayList<RoleEntity>();
				for (int i = 0; i < userDto.getRoleCodes().size(); i++)
					roles.add(roleRepo.findOneByCode(userDto.getRoleCodes().get(i)));
				userEntity.setRoles(roles);
			}

			return (T) userEntity;
		} else if (resObj instanceof CourseEntity) {
			CourseEntity courseEntity = (CourseEntity) resObj;
			CourseDTO courseDto = (CourseDTO) dto;

			// set roles
			if (courseDto.getScoreIds() != null) {
				List<ScoreEntity> scoreEntities = new ArrayList<ScoreEntity>();
				for (int i = 0; i < courseDto.getScoreIds().size(); i++)
					scoreEntities.add(scoreRepo.findOne(courseDto.getScoreIds().get(i)));
				courseEntity.setScores(scoreEntities);
			}

			return (T) courseEntity;
		} else if (resObj instanceof StudentEntity) {
			StudentEntity studentEntity = (StudentEntity) resObj;
			StudentDTO studentDto = (StudentDTO) dto;

			// set roles
			if (studentDto.getScoreIds() != null) {
				List<ScoreEntity> scoreEntities = new ArrayList<ScoreEntity>();
				for (int i = 0; i < studentDto.getScoreIds().size(); i++)
					scoreEntities.add(scoreRepo.findOne(studentDto.getScoreIds().get(i)));
				studentEntity.setScores(scoreEntities); 
			}

			return (T) studentEntity;
		}

		return resObj;
	}

	public MyUser toMyUser(UserDTO userDto) {
		if (userDto == null)
			return null;

		ModelMapper modelMapper = new ModelMapper();
		MyUser myUser = modelMapper.map(userDto, MyUser.class);

		// set authorities
		if (userDto.getRoleCodes() != null) {
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			for (int i = 0; i < userDto.getRoleCodes().size(); i++)
				authorities.add(new SimpleGrantedAuthority(userDto.getRoleCodes().get(i)));
			myUser.setAuthorities(authorities);
		}

		return myUser;
	}
}
