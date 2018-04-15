package com.railway.labor.career.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.mapper.UserRoleMapper;
import com.railway.labor.career.model.dto.UserRoleDTO;
import com.railway.labor.career.model.query.UserRoleQuery;

@Service
public class UserRoleDAO {
	@Autowired
	private UserRoleMapper userRoleMapper;

	public Long count(UserRoleQuery userRoleQuery) {
		return userRoleMapper.count(userRoleQuery);
	}
	public Pagination<UserRoleQuery, UserRoleDTO> query(Pagination<UserRoleQuery, UserRoleDTO> pagination) {
    	pagination.setResultTotal(count(pagination.getQuery()));
    	List<UserRoleDTO> userRoleDTOList = userRoleMapper.query(pagination.getQuery(),pagination);
    	pagination.setRows(userRoleDTOList);
		
		return pagination;
	}

	public UserRoleDTO get(Long id) {
		return userRoleMapper.get(id);
	}

	public void insert(UserRoleDTO userRoleDTO) {
		userRoleMapper.insert(userRoleDTO);
	}

	public void update(UserRoleDTO userRoleDTO) {
		userRoleMapper.insert(userRoleDTO);
	}

	public void delete(Long id) {
		userRoleMapper.delete(id);
	}
}
