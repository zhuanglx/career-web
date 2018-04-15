package com.railway.labor.career.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.dao.UserPermissionDAO;
import com.railway.labor.career.model.dto.UserPermissionDTO;
import com.railway.labor.career.model.query.UserPermissionQuery;

@Service
public class UserPermissionService {

	@Autowired
	private UserPermissionDAO userPermissionDAO;

	public Pagination<UserPermissionQuery, UserPermissionDTO> query(Pagination<UserPermissionQuery, UserPermissionDTO> pagination) {
		return userPermissionDAO.query(pagination);
	}

	public UserPermissionDTO get(Long id) {
		return userPermissionDAO.get(id);
	}

	public void insert(UserPermissionDTO userPermissionDTO) {
		userPermissionDAO.insert(userPermissionDTO);
	}

	public void update(UserPermissionDTO userPermissionDTO) {
		userPermissionDAO.insert(userPermissionDTO);
	}

	void delete(Long id) {
		userPermissionDAO.delete(id);
	}
}
