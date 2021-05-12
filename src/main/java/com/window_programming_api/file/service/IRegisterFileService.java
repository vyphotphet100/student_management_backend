package com.window_programming_api.file.service;

import com.window_programming_api.dto.RegisterDTO;

public interface IRegisterFileService {
	RegisterDTO printRegisterList();
	byte[] getFile(String source);
}
