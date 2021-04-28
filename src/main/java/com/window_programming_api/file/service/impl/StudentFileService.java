package com.window_programming_api.file.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import com.window_programming_api.dto.MyFileDTO;
import com.window_programming_api.dto.StudentDTO;
import com.window_programming_api.file.service.IStudentFileService;
import com.window_programming_api.utils.MyFileUtil;

@Service
public class StudentFileService extends BaseFileService implements IStudentFileService {

//	@Override
//	public StudentDTO upAvatar(String studentId, MyFileDTO fileDto) {
//		fileDto.setFileName("student/" + studentId + "/" + fileDto.getFileName());
//		String fileLink = fileService.upFileGetLink(fileDto);
//		StudentDTO studentDto = new StudentDTO();
//		studentDto.setPicture(fileLink);
//		return studentDto;
//	}
//
//	@Override
//	public StudentDTO upFile(MyFileDTO fileDto) {
//		fileDto.setFileName("student/" + fileDto.getFileName());
//		String fileLink = fileService.upFileGetLink(fileDto);
//		StudentDTO studentDto = new StudentDTO();
//		studentDto.setMessage(fileLink);
//		return studentDto;
//	}

	@Override
	public byte[] getFile(String source) {
		String fileName = source.split("/api/file/student/")[1];
		File rootPath = new File(MyFileUtil.removeDoubleSlash("src/main/resources/sources/student/" + fileName));
		return MyFileUtil.getByteBySource(rootPath.getAbsolutePath());
	}

	@Override
	public StudentDTO findOneByFileName(String fileName) {
		StudentDTO studentDto = new StudentDTO();
		File rootPath = new File(MyFileUtil.removeDoubleSlash("src/main/resources/sources/student/" + fileName));
		try {
			byte[] fileByte = MyFileUtil.getByteBySource(rootPath.getAbsolutePath());
			MyFileDTO fileDto = new MyFileDTO();
			fileDto.setFileName(fileName.split("\\.")[0]);
			fileDto.setFileType(fileName.split("\\.")[1]);
			fileDto.setBase64String(Base64.getEncoder().encodeToString(fileByte));

			studentDto.getListResult().add(fileDto);
			studentDto.setMessage("Load file to baseString64 successfully.");
			return studentDto;
		} catch (Exception ex) {
			return (StudentDTO) this.ExceptionObject(studentDto, "File is not found.");
		}
	}

	@Override
	public StudentDTO save(MyFileDTO fileDto) {
		StudentDTO studentDto = new StudentDTO();

		File filePath = new File(MyFileUtil.removeDoubleSlash(
				"src/main/resources/sources/student/" + fileDto.getFileName() + "." + fileDto.getFileType()));
		if (!filePath.exists()) {
			fileDto.setFileName("student/" + fileDto.getFileName());
			studentDto.getListResult().add(
					MyFileUtil.upFile(fileDto.getFileName() + "." + fileDto.getFileType(), fileDto.getBase64String()));
			studentDto.setMessage("Upload file successfully.");
			return studentDto;
		}

		return (StudentDTO) this.ExceptionObject(studentDto, "This file exists already.");
	}

	@Override
	public StudentDTO update(MyFileDTO fileDto) {
		StudentDTO studentDto = new StudentDTO();

		File filePath = new File(MyFileUtil.removeDoubleSlash(
				"src/main/resources/sources/student/" + fileDto.getFileName() + "." + fileDto.getFileType()));
		if (filePath.exists()) {
			fileDto.setFileName("student/" + fileDto.getFileName());
			studentDto.getListResult().add(
					MyFileUtil.upFile(fileDto.getFileName() + "." + fileDto.getFileType(), fileDto.getBase64String()));
			studentDto.setMessage("Update file successfully.");
			return studentDto;
		}

		return (StudentDTO) this.ExceptionObject(studentDto, "This file does not exists.");
	}

	@Override
	public StudentDTO delete(MyFileDTO fileDto) {
		StudentDTO studentDto = new StudentDTO();
		
		File filePath = new File(MyFileUtil.removeDoubleSlash(
				"src/main/resources/sources/student/" + fileDto.getFileName() + "." + fileDto.getFileType()));
		
		if (filePath.exists()) {
			try {
				FileUtils.forceDelete(filePath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			studentDto.setMessage("Delete file successfully.");
			return studentDto;
		}
		
		return (StudentDTO)this.ExceptionObject(studentDto, "File does not exist.");
	}

	@Override
	public StudentDTO deleteAll(String studentId) {
		StudentDTO studentDto = new StudentDTO();
		
		File studentDir = new File(MyFileUtil.removeDoubleSlash("src/main/resources/sources/student/" + studentId));
		try {
			FileUtils.deleteDirectory(studentDir);
			studentDto.setMessage("Delete all file(s) of student successfully.");
			return studentDto;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (StudentDTO) this.ExceptionObject(studentDto, "Delete all file(s) of student fail.");
	}

}
