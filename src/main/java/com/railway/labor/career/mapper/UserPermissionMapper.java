package com.railway.labor.career.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.model.dto.UserPermissionDTO;
import com.railway.labor.career.model.query.UserPermissionQuery;

public interface UserPermissionMapper {

	List<UserPermissionDTO> query(@Param("userPermissionQuery") UserPermissionQuery userPermissionQuery, @Param("pagination") Pagination<UserPermissionQuery, UserPermissionDTO> pagination);

	Long count(@Param("userPermissionQuery") UserPermissionQuery userPermissionQuery);

	UserPermissionDTO get(Long id);

	void insert(UserPermissionDTO userPermissionDTO);

	void update(UserPermissionDTO userPermissionDTO);

	void delete(Long id);
}
