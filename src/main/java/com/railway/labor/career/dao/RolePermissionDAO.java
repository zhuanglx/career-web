package com.railway.labor.career.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.mapper.RolePermissionMapper;
import com.railway.labor.career.model.dto.RolePermissionDTO;
import com.railway.labor.career.model.query.RolePermissionQuery;

@Service
public class RolePermissionDAO {
	@Autowired
	private RolePermissionMapper rolePermissionMapper;

	public Long count(RolePermissionQuery rolePermissionQuery) {
		return rolePermissionMapper.count(rolePermissionQuery);
	}
	public Pagination<RolePermissionQuery, RolePermissionDTO> query(RolePermissionQuery rolePermissionQuery) {
		Pagination<RolePermissionQuery, RolePermissionDTO> pagination = new Pagination<>();
		pagination.setQuery(rolePermissionQuery);
    	pagination.setResultTotal(count(rolePermissionQuery));
    	List<RolePermissionDTO> rolePermissionDTOList = rolePermissionMapper.query(rolePermissionQuery,pagination);
    	pagination.setRows(rolePermissionDTOList);
		
		return pagination;
	}

	public RolePermissionDTO get(Long id) {
		return rolePermissionMapper.get(id);
	}

	public void insert(RolePermissionDTO rolePermissionDTO) {
		rolePermissionMapper.insert(rolePermissionDTO);
	}

	public void update(RolePermissionDTO rolePermissionDTO) {
		rolePermissionMapper.insert(rolePermissionDTO);
	}

	public void delete(Long id) {
		rolePermissionMapper.delete(id);
	}
}
