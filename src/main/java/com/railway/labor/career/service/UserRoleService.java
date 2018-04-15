package com.railway.labor.career.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.dao.UserRoleDAO;
import com.railway.labor.career.model.dto.UserRoleDTO;
import com.railway.labor.career.model.query.UserRoleQuery;

@Service
public class UserRoleService {

	@Autowired
	private UserRoleDAO userRoleDAO;

	public Pagination<UserRoleQuery, UserRoleDTO> query(Pagination<UserRoleQuery, UserRoleDTO> pagination) {
		return userRoleDAO.query(pagination);
	}

	public UserRoleDTO get(Long id) {
		return userRoleDAO.get(id);
	}

	public void insert(UserRoleDTO userRoleDTO) {
		userRoleDAO.insert(userRoleDTO);
	}

	public void update(UserRoleDTO userRoleDTO) {
		userRoleDAO.insert(userRoleDTO);
	}

	void delete(Long id) {
		userRoleDAO.delete(id);
	}
}
