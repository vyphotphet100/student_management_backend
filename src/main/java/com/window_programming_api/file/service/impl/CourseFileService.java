package com.window_programming_api.file.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.window_programming_api.dto.CourseDTO;
import com.window_programming_api.dto.MyFileDTO;
import com.window_programming_api.entity.CourseEntity;
import com.window_programming_api.file.service.ICourseFileService;
import com.window_programming_api.repository.CourseRepository;
import com.window_programming_api.utils.MyFileUtil;
import com.window_programming_api.utils.POIUtil;

@Service
public class CourseFileService extends BaseFileService implements ICourseFileService {

	@Autowired
	private CourseRepository courseRepo;

	@Override
	public CourseDTO findAll() {
		return null;
	}

	public byte[] getFile(String source) {
		String fileName = source.split("/api/file/course/")[1];
		File rootPath = new File(
				MyFileUtil.removeDoubleSlash("src/main/resources/sources/course/" + fileName));
		return MyFileUtil.getByteBySource(rootPath.getAbsolutePath());
	}
	
	@Override
	public CourseDTO findOneByName(String fileName) {
		CourseDTO courseDto = new CourseDTO();
		File rootPath = new File(MyFileUtil.removeDoubleSlash("src/main/resources/sources/course/" + fileName));
		try {
			byte[] fileByte = MyFileUtil.getByteBySource(rootPath.getAbsolutePath());
			MyFileDTO fileDto = new MyFileDTO();
			fileDto.setFileName(fileName.split("\\.")[0]);
			fileDto.setFileType(fileName.split("\\.")[1]);
			fileDto.setBase64String(Base64.getEncoder().encodeToString(fileByte));
			
			courseDto.getListResult().add(fileDto);
			courseDto.setMessage("Load file to baseString64 successfully.");
			return courseDto;
		}
		catch(Exception ex) {
			return (CourseDTO)this.ExceptionObject(courseDto, "File is not found.");
		}

	}

	@Override
	public CourseDTO save(MyFileDTO fileDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseDTO update(MyFileDTO fileDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseDTO delete(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("resource")
	@Override
	public CourseDTO printCourseList() {
		CourseDTO courseDto = new CourseDTO();
		List<CourseEntity> courseEntities = courseRepo.findAll();

		// Create document
		// Blank Document
		XWPFDocument document = new XWPFDocument();

		// Write the Document in file system
		FileOutputStream out;
		try {
			File pathDoc = new File("src/main/resources/sources/course");
			if (!pathDoc.exists())
				pathDoc.mkdirs();

			out = new FileOutputStream(new File(pathDoc.getAbsolutePath() + "/list_of_course.docx"));

			// create Paragraph
			POIUtil.setRun(document.createParagraph().createRun(), 14, "DANH SÁCH MÔN HỌC: ", true);

			// create table
			XWPFTable table = document.createTable();
			// create first row
			XWPFTableRow tableRow = table.getRow(0);
			POIUtil.addParagraphToTableCell(tableRow.getCell(0), 14, "Course ID ", true);
			POIUtil.addParagraphToTableCell(tableRow.addNewTableCell(), 14, "Label ", true);
			POIUtil.addParagraphToTableCell(tableRow.addNewTableCell(), 14, "Period ", true);
			POIUtil.addParagraphToTableCell(tableRow.addNewTableCell(), 14, "Desciption ", true);

			for (int i = 0; i < courseEntities.size(); i++) {
				// create row after
				tableRow = table.createRow();
				POIUtil.addParagraphToTableCell(tableRow.getCell(0), 14, courseEntities.get(i).getCourseId(), false);
				POIUtil.addParagraphToTableCell(tableRow.getCell(1), 14, courseEntities.get(i).getLabel(), false);
				POIUtil.addParagraphToTableCell(tableRow.getCell(2), 14, courseEntities.get(i).getPeriod().toString(),
						false);
				POIUtil.addParagraphToTableCell(tableRow.getCell(3), 14, courseEntities.get(i).getDescription(), false);
			}

			document.write(out);
			out.close();

			System.out.println("list_of_course.docx written successully");
			String linkDocFile = "/api/file/course/list_of_course.docx";
			courseDto.getListResult().add(linkDocFile);
			courseDto.setMessage("list_of_course.docx written successully.");
			return courseDto;

		} catch (IOException e) {
			e.printStackTrace();
			return (CourseDTO) this.ExceptionObject(courseDto, e.toString());
		}
	}

}
