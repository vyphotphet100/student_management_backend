package com.window_programming_api.file.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageSz;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPageOrientation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.window_programming_api.dto.MyFileDTO;
import com.window_programming_api.dto.StudentDTO;
import com.window_programming_api.entity.StudentEntity;
import com.window_programming_api.file.service.IStudentFileService;
import com.window_programming_api.repository.StudentRepository;
import com.window_programming_api.utils.MyFileUtil;
import com.window_programming_api.utils.POIUtil;

@Service
public class StudentFileService extends BaseFileService implements IStudentFileService {

	@Autowired
	private StudentRepository studentRepo;

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
			studentDto.setMessage("Load file to base64String successfully.");
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

		return (StudentDTO) this.ExceptionObject(studentDto, "File does not exist.");
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

	@SuppressWarnings("deprecation")
	@Override
	public StudentDTO printStudentList() {
		StudentDTO studentDto = new StudentDTO();
		List<StudentEntity> studentEntities = studentRepo.findAll();

		// Create document
		// Blank Document
		@SuppressWarnings("resource")
		XWPFDocument document = new XWPFDocument();

		// set orientation to landscape
		CTBody body = document.getDocument().getBody();
		if (!body.isSetSectPr()) {
			body.addNewSectPr();
		}
		CTSectPr section = body.getSectPr();
		if (!section.isSetPgSz()) {
			section.addNewPgSz();
		}
		CTPageSz pageSize = section.getPgSz();
		pageSize.setOrient(STPageOrientation.LANDSCAPE);
		// A4 = 595x842 / multiply 20 since BigInteger represents 1/20 Point
		pageSize.setW(BigInteger.valueOf(16840));
		pageSize.setH(BigInteger.valueOf(11900));

		// Write the Document in file system
		FileOutputStream out;
		try {
			File pathDoc = new File("src/main/resources/sources/student");
			if (!pathDoc.exists())
				pathDoc.mkdirs();

			out = new FileOutputStream(new File(pathDoc.getAbsolutePath() + "/list_of_student.docx"));

			// create Paragraph
			POIUtil.setRun(document.createParagraph().createRun(), 14, "DANH SÁCH HỌC SINH: ", true);

			// create table
			XWPFTable table = document.createTable();
			// create first row
			XWPFTableRow tableRow = table.getRow(0);
			POIUtil.addParagraphToTableCell(tableRow.getCell(0), 14, "Student ID ", true);
			POIUtil.addParagraphToTableCell(tableRow.addNewTableCell(), 14, "First name ", true);
			POIUtil.addParagraphToTableCell(tableRow.addNewTableCell(), 14, "Last name ", true);
			POIUtil.addParagraphToTableCell(tableRow.addNewTableCell(), 14, "Address ", true);
			POIUtil.addParagraphToTableCell(tableRow.addNewTableCell(), 14, "Birthday ", true);
			POIUtil.addParagraphToTableCell(tableRow.addNewTableCell(), 14, "Gender ", true);
			POIUtil.addParagraphToTableCell(tableRow.addNewTableCell(), 14, "Phone ", true);
			POIUtil.addParagraphToTableCell(tableRow.addNewTableCell(), 14, "Picture ", true);

			for (int i = 0; i < studentEntities.size(); i++) {
				// create row after
				tableRow = table.createRow();
				POIUtil.addParagraphToTableCell(tableRow.getCell(0), 14, studentEntities.get(i).getId(), false);
				POIUtil.addParagraphToTableCell(tableRow.getCell(1), 14, studentEntities.get(i).getFirstName(), false);
				POIUtil.addParagraphToTableCell(tableRow.getCell(2), 14, studentEntities.get(i).getLastName(), false);
				POIUtil.addParagraphToTableCell(tableRow.getCell(3), 14, studentEntities.get(i).getAddress(), false);
				Date birthday = studentEntities.get(i).getBirthday();
				String birthdayStr = birthday.getDate() + "/" + (birthday.getMonth()+1) + "/" + (birthday.getYear()+1900);
				POIUtil.addParagraphToTableCell(tableRow.getCell(4), 14, birthdayStr, false);
				POIUtil.addParagraphToTableCell(tableRow.getCell(5), 14, studentEntities.get(i).getGender(), false);
				POIUtil.addParagraphToTableCell(tableRow.getCell(6), 14, studentEntities.get(i).getPhoneNumber(),
						false);
				POIUtil.addPictureToTableCell(tableRow.getCell(7),
						"src/main/resources/sources/student/" + studentEntities.get(i).getId() + "/avatar.png");
			}

			document.write(out);
			out.close();

			System.out.println("list_of_student.docx written successully");
			String linkDocFile = "/api/file/student/list_of_student.docx";
			studentDto.getListResult().add(linkDocFile);
			studentDto.setMessage("list_of_student.docx written successully.");
			return studentDto;

		} catch (IOException e) {
			e.printStackTrace();
			return (StudentDTO) this.ExceptionObject(studentDto, e.toString());
		}
	}

	@Override
	public StudentDTO findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
