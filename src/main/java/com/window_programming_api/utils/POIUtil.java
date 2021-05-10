package com.window_programming_api.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;

public class POIUtil {
	public static void setRun(XWPFRun run, int fontSize, String text, boolean bold) {
		run.setFontFamily("Times New Roman");
		run.setFontSize(fontSize);
		// run.setColor(colorRGB);
		run.setText(text);
		run.setBold(bold);
		//if (addBreak)
		//	run.addBreak();
	}
	
	public static void addParagraphToTableCell(XWPFTableCell tableCell, int fontSize, String text, boolean bold) {
		POIUtil.setRun(tableCell.addParagraph().createRun(), fontSize, text, bold);
		tableCell.removeParagraph(0);
	}
	
	public static void addPictureToTableCell(XWPFTableCell tableCell, String picturePath){
		// table is a XWPFTable object instantiated earlier in the code
		XWPFParagraph paragraph = tableCell.addParagraph();
		XWPFRun run = paragraph.createRun();
		FileInputStream fis;
		try {
			fis = new FileInputStream(picturePath);
			run.addPicture(fis, XWPFDocument.PICTURE_TYPE_PNG, "Name", Units.pixelToEMU(150), Units.pixelToEMU(150));
			//System.out.println(picture.getCTPicture());
		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tableCell.removeParagraph(0);
	}
}
