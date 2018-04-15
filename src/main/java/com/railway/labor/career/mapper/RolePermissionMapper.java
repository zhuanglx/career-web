package com.railway.labor.career.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.model.dto.RolePermissionDTO;
import com.railway.labor.career.model.query.RolePermissionQuery;

public interface RolePermissionMapper {

	List<RolePermissionDTO> query(@Param("rolePermissionQuery") RolePermissionQuery rolePermissionQuery, @Param("pagination") Pagination<RolePermissionQuery, RolePermissionDTO> pagination);

	Long count(@Param("rolePermissionQuery") RolePermissionQuery rolePermissionQuery);

	RolePermissionDTO get(Long id);

	void insert(RolePermissionDTO rolePermissionDTO);

	void update(RolePermissionDTO rolePermissionDTO);

	void delete(Long id);
}
