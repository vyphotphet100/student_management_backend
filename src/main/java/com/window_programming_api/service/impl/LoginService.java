package com.window_programming_api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.window_programming_api.dto.TokenDTO;
import com.window_programming_api.dto.UserDTO;
import com.window_programming_api.jwtutils.JwtUtil;
import com.window_programming_api.service.ILoginService;
import com.window_programming_api.service.ITokenService;
import com.window_programming_api.service.IUserService;

@Service
public class LoginService extends BaseService implements ILoginService {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private ITokenService tokenService;

	@Override
	public UserDTO checkUser(UserDTO userDto) {
		UserDTO resUserDto = userService.findOneByUserNameAndPassword(userDto.getUserName(), userDto.getPassword());
		if (resUserDto.getHttpStatus().equals(HttpStatus.OK)) {
			TokenDTO tokenDto = tokenService.findOneByCode(resUserDto.getTokenCode());
			resUserDto.setTokenCode(JwtUtil.getKeyTokenTail(resUserDto.getTokenCode()));
			String newToken = JwtUtil.generateToken(resUserDto);
			tokenDto.setCode(newToken);
			tokenDto = tokenService.update(tokenDto);
			
			resUserDto = userService.findOneByTokenCode(tokenDto.getCode());
			resUserDto.setPassword(null);
			resUserDto.setMessage("Login successfully!");
			return resUserDto;
		}
		
		return (UserDTO)ExceptionObject(userDto, "Username or password incorrect. Please re-check!");
	}

}
