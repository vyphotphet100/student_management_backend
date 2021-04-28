package com.window_programming_api.file.service;

import javax.servlet.http.HttpServletRequest;

import com.window_programming_api.dto.MyFileDTO;

public interface IFileService extends IBaseFileService {
	String upFileGetLink(MyFileDTO fileDTO);
	byte[] getFileAsByte(HttpServletRequest request, String moduleURL);
	void deleteFolder(String folderPath);
}
