package com.railway.labor.career.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.dao.RolePermissionDAO;
import com.railway.labor.career.model.dto.RolePermissionDTO;
import com.railway.labor.career.model.query.RolePermissionQuery;

@Service
public class RolePermissionService {

	@Autowired
	private RolePermissionDAO rolePermissionDAO;

	public Pagination<RolePermissionQuery, RolePermissionDTO> query(RolePermissionQuery rolePermissionQuery) {
		return rolePermissionDAO.query(rolePermissionQuery);
	}

	public RolePermissionDTO get(Long id) {
		return rolePermissionDAO.get(id);
	}

	public void insert(RolePermissionDTO rolePermissionDTO) {
		rolePermissionDAO.insert(rolePermissionDTO);
	}

	public void update(RolePermissionDTO rolePermissionDTO) {
		rolePermissionDAO.insert(rolePermissionDTO);
	}

	void delete(Long id) {
		rolePermissionDAO.delete(id);
	}
}
