package com.railway.labor.career.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.dao.RoleDAO;
import com.railway.labor.career.model.dto.RoleDTO;
import com.railway.labor.career.model.query.RoleQuery;

@Service
public class RoleService {

	@Autowired
	private RoleDAO roleDAO;

	public Pagination<RoleQuery, RoleDTO> query(RoleQuery roleQuery) {
		return roleDAO.query(roleQuery);
	}

	public RoleDTO get(Long id) {
		return roleDAO.get(id);
	}

	public void insert(RoleDTO roleDTO) {
		roleDAO.insert(roleDTO);
	}

	public void update(RoleDTO roleDTO) {
		roleDAO.insert(roleDTO);
	}

	void delete(Long id) {
		roleDAO.delete(id);
	}
}
