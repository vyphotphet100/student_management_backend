package com.window_programming_api.service;

import com.window_programming_api.dto.UserDTO;

public interface IUserService extends IBaseService{
	UserDTO findOneByUserName(String userName);
	UserDTO findOneByUserNameAndPassword(String username, String password);
	UserDTO findOneByTokenCode(String tokenCode);
	UserDTO findAll();
	UserDTO save(UserDTO userDto);
	UserDTO update(UserDTO userDto);
}
