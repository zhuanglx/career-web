package com.railway.labor.career.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.model.dto.PermissionDTO;
import com.railway.labor.career.model.query.PermissionQuery;

public interface PermissionMapper {

	List<PermissionDTO> query(@Param("permissionQuery") PermissionQuery permissionQuery, @Param("pagination") Pagination<PermissionQuery, PermissionDTO> pagination);

	Long count(@Param("permissionQuery") PermissionQuery permissionQuery);

	PermissionDTO get(Long id);

	void insert(PermissionDTO permissionDTO);

	void update(PermissionDTO permissionDTO);

	void delete(Long id);
}
