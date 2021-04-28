package com.window_programming_api.service;

import com.window_programming_api.dto.RoleDTO;

public interface IRoleService extends IBaseService{
	RoleDTO findOneByCode(String code);
}
