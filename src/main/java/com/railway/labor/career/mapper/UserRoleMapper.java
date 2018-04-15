package com.railway.labor.career.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.model.dto.RoleDTO;
import com.railway.labor.career.model.dto.UserDTO;
import com.railway.labor.career.model.dto.UserRoleDTO;
import com.railway.labor.career.model.query.UserRoleQuery;

public interface UserRoleMapper {

	List<RoleDTO> queryRoles(@Param("userRoleQuery") UserRoleQuery userRoleQuery, @Param("pagination") Pagination<UserRoleQuery, RoleDTO> pagination);

	List<UserDTO> queryUsers(@Param("userRoleQuery") UserRoleQuery userRoleQuery, @Param("pagination") Pagination<UserRoleQuery, RoleDTO> pagination);

	List<UserRoleDTO> query(@Param("userRoleQuery") UserRoleQuery userRoleQuery, @Param("pagination") Pagination<UserRoleQuery, UserRoleDTO> pagination);

	Long count(@Param("userRoleQuery") UserRoleQuery userRoleQuery);

	UserRoleDTO get(Long id);

	void insert(UserRoleDTO userRoleDTO);

	void update(UserRoleDTO userRoleDTO);

	void delete(Long id);
}
