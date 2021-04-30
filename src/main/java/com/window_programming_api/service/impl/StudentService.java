package com.window_programming_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.window_programming_api.dto.StudentDTO;
import com.window_programming_api.entity.StudentEntity;
import com.window_programming_api.file.service.IStudentFileService;
import com.window_programming_api.repository.StudentRepository;
import com.window_programming_api.service.IStudentService;

@Service
public class StudentService extends BaseService implements IStudentService {

	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private IStudentFileService studentFileService;

	@Override
	public StudentDTO save(StudentDTO studentDto) {
		// check if student exists already
		if (studentRepo.findOneById(studentDto.getId()) == null) {
			StudentEntity studentEntity = studentRepo.save(converter.toEntity(studentDto, StudentEntity.class));
			StudentDTO resDto = converter.toDTO(studentEntity, StudentDTO.class);
			resDto.setMessage("Add student successfully.");
			return resDto;
		}

		return (StudentDTO) this.ExceptionObject(studentDto, "Student exists already.");
	}

	@Override
	public StudentDTO update(StudentDTO studentDto) {
		// check if student exists already
		if (studentRepo.findOneById(studentDto.getId()) != null) {
			StudentEntity studentEntity = studentRepo.save(converter.toEntity(studentDto, StudentEntity.class));
			studentDto = converter.toDTO(studentEntity, StudentDTO.class);
			studentDto.setMessage("Update student successfully.");
			return studentDto;
		}

		return (StudentDTO) this.ExceptionObject(studentDto, "Student does not exist.");
	}

	@Override
	public StudentDTO findAll() {
		StudentDTO studentDto = new StudentDTO();
		List<StudentEntity> studentEntities = studentRepo.findAll();

		if (!studentEntities.isEmpty()) {
			for (int i = 0; i < studentEntities.size(); i++)
				studentDto.getListResult().add(converter.toDTO(studentEntities.get(i), StudentDTO.class));
			studentDto.setMessage("Load student list successfully.");
			return studentDto;
		}

		return (StudentDTO) this.ExceptionObject(studentDto, "There is no student.");
	}

	@Override
	public StudentDTO findOne(String studentId) {
		StudentDTO studentDto = converter.toDTO(studentRepo.findOne(studentId), StudentDTO.class);
		if (studentDto != null) {
			studentDto.setMessage("Load student successfully.");
			return studentDto;
		}

		return (StudentDTO) this.ExceptionObject(new StudentDTO(),
				"Student having studentId=" + studentId + " is not found.");
	}

	@Override
	public StudentDTO delete(String studentId) {
		StudentDTO studentDto = new StudentDTO();
		studentDto.setId(studentId);

		if (studentRepo.findOne(studentId) != null) {
			// delete student in database
			studentRepo.delete(studentId);

			//////////////////////////////////////////////////////////////
			// delete student file
			// studentDto.getListRequest().add((String) studentId);
			// studentFileService.delete(studentDto);

			// delete student
			studentFileService.deleteAll(studentId);

			studentDto.setMessage("Delete student successfully.");
			return studentDto;
		}

		return (StudentDTO) this.ExceptionObject(studentDto,
				"Student having studentId=" + studentId + " is not found.");
	}
}
