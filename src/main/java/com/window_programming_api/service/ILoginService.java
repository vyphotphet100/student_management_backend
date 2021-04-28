package com.window_programming_api.service;

import com.window_programming_api.dto.UserDTO;

public interface ILoginService extends IBaseService {
	UserDTO checkUser(UserDTO userDto);
}
