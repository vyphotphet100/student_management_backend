package com.window_programming_api.utils;

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
}
