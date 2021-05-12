package com.window_programming_api.file.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.window_programming_api.dto.RegisterDTO;
import com.window_programming_api.entity.RegisterEntity;
import com.window_programming_api.file.service.IRegisterFileService;
import com.window_programming_api.repository.RegisterRepository;
import com.window_programming_api.utils.MyFileUtil;
import com.window_programming_api.utils.POIUtil;

@Service
public class RegisterFileService extends BaseFileService implements IRegisterFileService {

	@Autowired
	private RegisterRepository registerRepo;

	@SuppressWarnings("resource")
	@Override
	public RegisterDTO printRegisterList() {
		RegisterDTO registerDto = new RegisterDTO();
		List<RegisterEntity> registerEntities = registerRepo.findAll();

		// Create document
		// Blank Document
		XWPFDocument document = new XWPFDocument();

		// Write the Document in file system
		FileOutputStream out;
		try {
			File pathDoc = new File("src/main/resources/sources/register");
			if (!pathDoc.exists())
				pathDoc.mkdirs();

			out = new FileOutputStream(new File(pathDoc.getAbsolutePath() + "/list_of_register.docx"));

			// create Paragraph
			POIUtil.setRun(document.createParagraph().createRun(), 14, "DANH SÁCH ĐIỂM CỦA SINH VIÊN: ", true);

			// create table
			XWPFTable table = document.createTable();
			// create first row
			XWPFTableRow tableRow = table.getRow(0);
			POIUtil.addParagraphToTableCell(tableRow.getCell(0), 14, "Student ID ", true);
			POIUtil.addParagraphToTableCell(tableRow.addNewTableCell(), 14, "Course ID ", true);
			POIUtil.addParagraphToTableCell(tableRow.addNewTableCell(), 14, "Course label ", true);
			POIUtil.addParagraphToTableCell(tableRow.addNewTableCell(), 14, "Score ", true);
			POIUtil.addParagraphToTableCell(tableRow.addNewTableCell(), 14, "Description ", true);

			for (int i = 0; i < registerEntities.size(); i++) {
				// create row after
				tableRow = table.createRow();
				POIUtil.addParagraphToTableCell(tableRow.getCell(0), 14, registerEntities.get(i).getStudent().getId(),
						false);
				POIUtil.addParagraphToTableCell(tableRow.getCell(1), 14,
						registerEntities.get(i).getSectionClass().getId(), false);
				POIUtil.addParagraphToTableCell(tableRow.getCell(2), 14,
						registerEntities.get(i).getSectionClass().getName(), false);
				POIUtil.addParagraphToTableCell(tableRow.getCell(3), 14,
						String.valueOf(registerEntities.get(i).getEndTermMark()), false);
				POIUtil.addParagraphToTableCell(tableRow.getCell(4), 14, registerEntities.get(i).getDescription(),
						false);
			}

			document.write(out);
			out.close();

			System.out.println("list_of_register.docx written successully");
			String linkDocFile = "/api/file/register/list_of_register.docx";
			registerDto.getListResult().add(linkDocFile);
			registerDto.setMessage("list_of_register.docx written successully.");
			return registerDto;

		} catch (IOException e) {
			e.printStackTrace();
			return (RegisterDTO) this.ExceptionObject(registerDto, e.toString());
		}
	}

	@Override
	public byte[] getFile(String source) {
		String fileName = source.split("/api/file/register/")[1];
		File rootPath = new File(MyFileUtil.removeDoubleSlash("src/main/resources/sources/register/" + fileName));
		return MyFileUtil.getByteBySource(rootPath.getAbsolutePath());
	}

}
