package com.railway.labor.career.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.mapper.UserPermissionMapper;
import com.railway.labor.career.model.dto.UserPermissionDTO;
import com.railway.labor.career.model.query.UserPermissionQuery;

@Service
public class UserPermissionDAO {
	@Autowired
	private UserPermissionMapper userPermissionMapper;

	public Long count(UserPermissionQuery userPermissionQuery) {
		return userPermissionMapper.count(userPermissionQuery);
	}
	public Pagination<UserPermissionQuery, UserPermissionDTO> query(Pagination<UserPermissionQuery, UserPermissionDTO> pagination) {
    	//pagination.setResultTotal(count(pagination.getQuery()));
    	List<UserPermissionDTO> userPermissionDTOList = userPermissionMapper.query(pagination.getQuery(),pagination);
    	pagination.setRows(userPermissionDTOList);
		
		return pagination;
	}

	public UserPermissionDTO get(Long id) {
		return userPermissionMapper.get(id);
	}

	public void insert(UserPermissionDTO userPermissionDTO) {
		userPermissionMapper.insert(userPermissionDTO);
	}

	public void update(UserPermissionDTO userPermissionDTO) {
		userPermissionMapper.insert(userPermissionDTO);
	}

	public void delete(Long id) {
		userPermissionMapper.delete(id);
	}
}
