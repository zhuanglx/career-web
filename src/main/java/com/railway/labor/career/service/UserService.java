package com.railway.labor.career.service;

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
	public LoginInfoDTO login(String account, String password) {
		return userDAO.login(account, password);
	}

	public Pagination<UserQuery, UserDTO> query(Pagination<UserQuery, UserDTO> pagination) {
		return userDAO.query(pagination);
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
