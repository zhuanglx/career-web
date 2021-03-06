package com.railway.labor.career.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.dao.PermissionDAO;
import com.railway.labor.career.model.dto.PermissionDTO;
import com.railway.labor.career.model.query.PermissionQuery;

@Service
public class PermissionService {

	@Autowired
	private PermissionDAO permissionDAO;

	public Pagination<PermissionQuery, PermissionDTO> query(Pagination<PermissionQuery, PermissionDTO> pagination) {
		return permissionDAO.query(pagination);
	}

	public List<PermissionDTO> queryByIds(List<Long> ids) {
		return permissionDAO.queryByIds(ids);
	}
	
	public PermissionDTO get(Long id) {
		return permissionDAO.get(id);
	}

	public void insert(PermissionDTO permissionDTO) {
		permissionDAO.insert(permissionDTO);
	}

	public void update(PermissionDTO permissionDTO) {
		permissionDAO.insert(permissionDTO);
	}

	void delete(Long id) {
		permissionDAO.delete(id);
	}
}
