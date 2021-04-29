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
import com.window_programming_api.dto.LecturerDTO;
import com.window_programming_api.dto.MyUser;
import com.window_programming_api.dto.RegisterDTO;
import com.window_programming_api.dto.RoleDTO;
import com.window_programming_api.dto.SectionClassDTO;
import com.window_programming_api.dto.StudentDTO;
import com.window_programming_api.dto.TokenDTO;
import com.window_programming_api.dto.UserDTO;
import com.window_programming_api.entity.CourseEntity;
import com.window_programming_api.entity.LecturerEntity;
import com.window_programming_api.entity.RegisterEntity;
import com.window_programming_api.entity.RoleEntity;
import com.window_programming_api.entity.SectionClassEntity;
import com.window_programming_api.entity.StudentEntity;
import com.window_programming_api.entity.TokenEntity;
import com.window_programming_api.entity.UserEntity;
import com.window_programming_api.repository.RegisterRepository;
import com.window_programming_api.repository.RoleRepository;
import com.window_programming_api.repository.SectionClassRepository;
import com.window_programming_api.repository.StudentRepository;
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
	private SectionClassRepository sectionClassRepo;

	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private RegisterRepository registerRepo;

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

			// set section class id
			if (courseEntity.getSectionClasses() != null) {
				for (int i = 0; i < courseEntity.getSectionClasses().size(); i++)
					courseDto.getSectionClassIds().add(courseEntity.getSectionClasses().get(i).getId());
			}

			return (T) courseDto;
		} else if (resObj instanceof LecturerDTO) {
			LecturerDTO lecturerDto = (LecturerDTO) resObj;
			LecturerEntity lecturerEntity = (LecturerEntity) entity;

			// set section class id
			if (lecturerEntity.getSectionClasses() != null) {
				for (int i = 0; i < lecturerEntity.getSectionClasses().size(); i++)
					lecturerDto.getSectionClassIds().add(lecturerEntity.getSectionClasses().get(i).getId());
			}

			return (T) lecturerDto;
		} else if (resObj instanceof RegisterDTO) {
			RegisterDTO registerDto = (RegisterDTO) resObj;
			RegisterEntity registerEntity = (RegisterEntity) entity;

			// set student id
			registerDto.setStudentId(registerEntity.getStudent().getId());
			// set sectionClassId
			registerDto.setSectionClassId(registerEntity.getSectionClass().getId());

			return (T) registerEntity;
		} else if (resObj instanceof StudentDTO) {
			StudentDTO studentDto = (StudentDTO) resObj;
			StudentEntity studentEntity = (StudentEntity) entity;

			// set id
			studentDto.setStudentId(studentEntity.getId());
			// set registerIds
			if (studentEntity.getRegisters() != null) {
				for (int i = 0; i < studentEntity.getRegisters().size(); i++)
					studentDto.getRegisterIds().add(studentEntity.getRegisters().get(i).getId());
			}

			return (T) studentDto;
		} else if (resObj instanceof SectionClassDTO) {
			SectionClassDTO sectionClassDto = (SectionClassDTO) resObj;
			SectionClassEntity sectionClassEntity = (SectionClassEntity) entity;

			// set id
			sectionClassDto.setSectionClassId(sectionClassEntity.getId());
			// set registerIds
			if (sectionClassEntity.getRegisters() != null) {
				for (int i = 0; i < sectionClassEntity.getRegisters().size(); i++)
					sectionClassDto.getRegisterIds().add(sectionClassEntity.getRegisters().get(i).getId());
			}

			return (T) sectionClassDto;
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
			if (courseDto.getSectionClassIds() != null) {
				for (int i = 0; i < courseDto.getSectionClassIds().size(); i++)
					courseEntity.getSectionClasses()
							.add(sectionClassRepo.findOneById(courseDto.getSectionClassIds().get(i)));
			}

			return (T) courseEntity;
		} else if (resObj instanceof LecturerEntity) {
			LecturerEntity lecturerEntity = (LecturerEntity) resObj;
			LecturerDTO lecturerDto = (LecturerDTO) dto;

			// set roles
			if (lecturerDto.getSectionClassIds() != null) {
				for (int i = 0; i < lecturerDto.getSectionClassIds().size(); i++)
					lecturerEntity.getSectionClasses()
							.add(sectionClassRepo.findOneById(lecturerDto.getSectionClassIds().get(i)));
			}

			return (T) lecturerEntity;
		} else if (resObj instanceof RegisterEntity) {
			RegisterEntity registerEntity = (RegisterEntity) resObj;
			RegisterDTO registerDto = (RegisterDTO) dto;

			// set student
			registerEntity.setStudent(studentRepo.findOne(registerDto.getStudentId()));
			// set sectionClassId
			registerEntity.setSectionClass(sectionClassRepo.findOne(registerDto.getSectionClassId()));

			return (T) registerEntity;
		} else if (resObj instanceof StudentEntity) {
			StudentEntity studentEntity = (StudentEntity) resObj;
			StudentDTO studentDto = (StudentDTO) dto;

			//set id
			studentEntity.setId(studentDto.getStudentId());
			// set roles
			if (studentDto.getRegisterIds() != null) {
				for (int i = 0; i < studentDto.getRegisterIds().size(); i++)
					studentEntity.getRegisters().add(registerRepo.findOne(studentDto.getRegisterIds().get(i)));
			}

			return (T) studentEntity;
		} else if (resObj instanceof SectionClassEntity) {
			SectionClassEntity sectionClassEntity = (SectionClassEntity) resObj;
			SectionClassDTO sectionClassDto = (SectionClassDTO) dto;

			// set id
			sectionClassEntity.setId(sectionClassDto.getSectionClassId());
			// set registers
			if (sectionClassDto.getRegisterIds() != null) {
				for (int i = 0; i < sectionClassDto.getRegisterIds().size(); i++)
					sectionClassEntity.getRegisters()
							.add(registerRepo.findOne(sectionClassDto.getRegisterIds().get(i)));
			}

			return (T) sectionClassEntity;
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
