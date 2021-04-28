package com.window_programming_api.file.service;

import com.window_programming_api.dto.MyFileDTO;
import com.window_programming_api.dto.StudentDTO;

public interface IStudentFileService extends IBaseFileService{
	//StudentDTO upAvatar(String studentId, MyFileDTO fileDto);
	//StudentDTO upFile(MyFileDTO fileDto);
	
	byte[] getFile(String source);
	StudentDTO findOneByFileName(String fileName);
	StudentDTO save(MyFileDTO fileDto);
	StudentDTO update(MyFileDTO fileDto);
	StudentDTO delete(MyFileDTO fileDto);
	StudentDTO deleteAll(String studentId);
}
