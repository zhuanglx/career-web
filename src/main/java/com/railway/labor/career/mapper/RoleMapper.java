package com.railway.labor.career.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.model.dto.RoleDTO;
import com.railway.labor.career.model.query.RoleQuery;

public interface RoleMapper {

	List<RoleDTO> query(@Param("roleQuery") RoleQuery roleQuery, @Param("pagination") Pagination<RoleQuery, RoleDTO> pagination);

	Long count(@Param("roleQuery") RoleQuery roleQuery);

	RoleDTO get(Long id);

	void insert(RoleDTO roleDTO);

	void update(RoleDTO roleDTO);

	void delete(Long id);
}
