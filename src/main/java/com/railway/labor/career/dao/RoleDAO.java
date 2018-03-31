package com.railway.labor.career.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.mapper.RoleMapper;
import com.railway.labor.career.model.dto.RoleDTO;
import com.railway.labor.career.model.query.RoleQuery;

@Service
public class RoleDAO {
	@Autowired
	private RoleMapper roleMapper;

	public Long count(RoleQuery roleQuery) {
		return roleMapper.count(roleQuery);
	}
	public Pagination<RoleQuery, RoleDTO> query(RoleQuery roleQuery) {
		Pagination<RoleQuery, RoleDTO> pagination = new Pagination<>();
		pagination.setQuery(roleQuery);
    	pagination.setResultTotal(count(roleQuery));
    	List<RoleDTO> roleDTOList = roleMapper.query(roleQuery,pagination);
    	pagination.setRows(roleDTOList);
		
		return pagination;
	}

	public RoleDTO get(Long id) {
		return roleMapper.get(id);
	}

	public void insert(RoleDTO roleDTO) {
		roleMapper.insert(roleDTO);
	}

	public void update(RoleDTO roleDTO) {
		roleMapper.insert(roleDTO);
	}

	public void delete(Long id) {
		roleMapper.delete(id);
	}
}
