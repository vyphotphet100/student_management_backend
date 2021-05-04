package com.window_programming_api.converter;

import java.util.ArrayList;
import java.util.Collection;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.window_programming_api.dto.CourseDTO;
import com.window_programming_api.dto.EducationTrainingDTO;
import com.window_programming_api.dto.LecturerDTO;
import com.window_programming_api.dto.RegisterDTO;
import com.window_programming_api.dto.RoleDTO;
import com.window_programming_api.dto.SectionClassDTO;
import com.window_programming_api.dto.StudentDTO;
import com.window_programming_api.entity.CourseEntity;
import com.window_programming_api.entity.EducationTrainingEntity;
import com.window_programming_api.entity.LecturerEntity;
import com.window_programming_api.entity.RegisterEntity;
import com.window_programming_api.entity.RoleEntity;
import com.window_programming_api.entity.SectionClassEntity;
import com.window_programming_api.entity.StudentEntity;
import com.window_programming_api.repository.RegisterRepository;
import com.window_programming_api.repository.SectionClassRepository;
import com.window_programming_api.repository.StudentRepository;

@Component
public class Converter {

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

		if (resObj instanceof RoleDTO) {
			RoleDTO roleDto = (RoleDTO) resObj;
			RoleEntity roleEntity = (RoleEntity) entity;

			// set student ids
			if (roleEntity.getStudents() != null) {
				for (int i = 0; i < roleEntity.getStudents().size(); i++)
					roleDto.getStudentIds().add(roleEntity.getStudents().get(i).getId());
			}

			// set lecturer ids
			if (roleEntity.getLecturers() != null) {
				for (int i = 0; i < roleEntity.getLecturers().size(); i++)
					roleDto.getLecturerIds().add(roleEntity.getLecturers().get(i).getId());
			}

			// set education training ids
			if (roleEntity.getEducationTrainings() != null) {
				for (int i = 0; i < roleEntity.getEducationTrainings().size(); i++)
					roleDto.getEducationTrainingUsernames().add(roleEntity.getEducationTrainings().get(i).getUsername());
			}

			return (T) roleDto;
		} else if (resObj instanceof CourseDTO) {
			CourseDTO courseDto = (CourseDTO) resObj;
			CourseEntity courseEntity = (CourseEntity) entity;

			// set section class ids
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

			// set role code
			lecturerDto.setRoleCode(lecturerEntity.getRole().getCode());

			// set authorities
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(lecturerDto.getRoleCode()));
			lecturerDto.setAuthorities(authorities);

			return (T) lecturerDto;
		} else if (resObj instanceof RegisterDTO) {
			RegisterDTO registerDto = (RegisterDTO) resObj;
			RegisterEntity registerEntity = (RegisterEntity) entity;

			// set student id
			registerDto.setStudentId(registerEntity.getStudent().getId());
			// set sectionClassId
			registerDto.setSectionClassId(registerEntity.getSectionClass().getId());

			return (T) registerDto;
		} else if (resObj instanceof StudentDTO) {
			StudentDTO studentDto = (StudentDTO) resObj;
			StudentEntity studentEntity = (StudentEntity) entity;

			// set registerIds
			if (studentEntity.getRegisters() != null) {
				for (int i = 0; i < studentEntity.getRegisters().size(); i++)
					studentDto.getRegisterIds().add(studentEntity.getRegisters().get(i).getId());
			}

			// set role code
			studentDto.setRoleCode(studentEntity.getRole().getCode());

			// set authorities
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(studentDto.getRoleCode()));
			studentDto.setAuthorities(authorities);

			return (T) studentDto;
		} else if (resObj instanceof SectionClassDTO) {
			SectionClassDTO sectionClassDto = (SectionClassDTO) resObj;
			SectionClassEntity sectionClassEntity = (SectionClassEntity) entity;

			// set registerIds
			if (sectionClassEntity.getRegisters() != null) {
				for (int i = 0; i < sectionClassEntity.getRegisters().size(); i++)
					sectionClassDto.getRegisterIds().add(sectionClassEntity.getRegisters().get(i).getId());
			}

			return (T) sectionClassDto;
		} else if (resObj instanceof EducationTrainingDTO) {
			EducationTrainingDTO educationTrainingDto = (EducationTrainingDTO) resObj;
			EducationTrainingEntity educationTrainingEntity = (EducationTrainingEntity) entity;

			// set role code
			educationTrainingDto.setRoleCode(educationTrainingEntity.getRole().getCode());
			// set authorities
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(educationTrainingDto.getRoleCode()));
			educationTrainingDto.setAuthorities(authorities);

			return (T) educationTrainingDto;
		}

		return resObj;
	}

	@SuppressWarnings("unchecked")
	public <T> T toEntity(Object dto, Class<T> tClass) {
		if (dto == null)
			return null;

		ModelMapper modelMapper = new ModelMapper();
		T resObj = modelMapper.map(dto, tClass);

		if (resObj instanceof CourseEntity) {
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

			// set roles
			if (studentDto.getRegisterIds() != null) {
				for (int i = 0; i < studentDto.getRegisterIds().size(); i++)
					studentEntity.getRegisters().add(registerRepo.findOne(studentDto.getRegisterIds().get(i)));
			}

			return (T) studentEntity;
		} else if (resObj instanceof SectionClassEntity) {
			SectionClassEntity sectionClassEntity = (SectionClassEntity) resObj;
			SectionClassDTO sectionClassDto = (SectionClassDTO) dto;

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

//	public MyUser toMyUser(UserDTO userDto) {
//		if (userDto == null)
//			return null;
//
//		ModelMapper modelMapper = new ModelMapper();
//		MyUser myUser = modelMapper.map(userDto, MyUser.class);
//
//		// set authorities
//		if (userDto.getRoleCodes() != null) {
//			Collection<GrantedAuthority> authorities = new ArrayList<>();
//			for (int i = 0; i < userDto.getRoleCodes().size(); i++)
//				authorities.add(new SimpleGrantedAuthority(userDto.getRoleCodes().get(i)));
//			myUser.setAuthorities(authorities);
//		}
//
//		return myUser;
//	}
}
