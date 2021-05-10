package com.window_programming_api.file.service;

import com.window_programming_api.dto.SectionClassDTO;

public interface ISectionClassFileService extends IBaseFileService{

	SectionClassDTO printSectionClassList();
	byte[] getFile(String source);
}
