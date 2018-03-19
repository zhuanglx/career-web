package com.railway.labor.career.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.dao.UserDAO;
import com.railway.labor.career.model.dto.LoginInfoDTO;
import com.railway.labor.career.model.dto.UserDTO;
import com.railway.labor.career.model.query.UserQuery;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	public LoginInfoDTO login(String userNo, String password) {
		return userDAO.login(userNo, password);
	}

	public Pagination<UserQuery, UserDTO> query(UserQuery userQuery) {
		return userDAO.query(userQuery);
	}

	public UserDTO get(Long id) {
		return userDAO.get(id);
	}

	public void insert(UserDTO userDTO) {
		userDAO.insert(userDTO);
	}

	public void update(UserDTO userDTO) {
		userDAO.insert(userDTO);
	}

	void delete(Long id) {
		userDAO.delete(id);
	}
}
