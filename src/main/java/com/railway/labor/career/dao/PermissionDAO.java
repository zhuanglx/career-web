package com.railway.labor.career.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.mapper.PermissionMapper;
import com.railway.labor.career.model.dto.PermissionDTO;
import com.railway.labor.career.model.query.PermissionQuery;

@Service
public class PermissionDAO {
	@Autowired
	private PermissionMapper permissionMapper;

	public Long count(PermissionQuery permissionQuery) {
		return permissionMapper.count(permissionQuery);
	}
	
	public Pagination<PermissionQuery, PermissionDTO> query(Pagination<PermissionQuery, PermissionDTO> pagination) {
    	pagination.setResultTotal(count(pagination.getQuery()));
    	List<PermissionDTO> permissionDTOList = permissionMapper.query(pagination.getQuery(),pagination);
    	pagination.setRows(permissionDTOList);
		return pagination;
	}
	
	public List<PermissionDTO> queryByIds(List<Long> ids) {
		if(CollectionUtils.isEmpty(ids)){
			return new ArrayList<>(0);
		}
		return permissionMapper.queryByIds(ids);
	}
	
	public PermissionDTO get(Long id) {
		return permissionMapper.get(id);
	}

	public void insert(PermissionDTO permissionDTO) {
		permissionMapper.insert(permissionDTO);
	}

	public void update(PermissionDTO permissionDTO) {
		permissionMapper.insert(permissionDTO);
	}

	public void delete(Long id) {
		permissionMapper.delete(id);
	}
}
