package com.railway.labor.career.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.mapper.UserMapper;
import com.railway.labor.career.model.dto.LoginInfoDTO;
import com.railway.labor.career.model.dto.UserDTO;
import com.railway.labor.career.model.query.UserQuery;

@Service
public class UserDAO {
	@Autowired
	private UserMapper userMapper;

	public LoginInfoDTO login(String userNo, String password) {
		return userMapper.login(userNo, password);
	}
	public Long count(UserQuery userQuery) {
		return userMapper.count(userQuery);
	}
	public Pagination<UserQuery, UserDTO> query(UserQuery userQuery) {
		Pagination<UserQuery, UserDTO> pagination = new Pagination<>();
		pagination.setQuery(userQuery);
    	pagination.setResultTotal(count(userQuery));
    	List<UserDTO> userDTOList = userMapper.query(userQuery,pagination);
    	pagination.setRows(userDTOList);
		
		return pagination;
	}

	public UserDTO get(Long id) {
		return userMapper.get(id);
	}

	public void insert(UserDTO userDTO) {
		userMapper.insert(userDTO);
	}

	public void update(UserDTO userDTO) {
		userMapper.insert(userDTO);
	}

	public void delete(Long id) {
		userMapper.delete(id);
	}
}
