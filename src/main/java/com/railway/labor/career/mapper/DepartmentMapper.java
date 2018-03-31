package com.railway.labor.career.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.model.dto.DepartmentDTO;
import com.railway.labor.career.model.query.DepartmentQuery;

public interface DepartmentMapper {

	List<DepartmentDTO> query(@Param("departmentQuery") DepartmentQuery departmentQuery, @Param("pagination") Pagination<DepartmentQuery, DepartmentDTO> pagination);

	Long count(@Param("departmentQuery") DepartmentQuery departmentQuery);

	DepartmentDTO get(Long id);

	void insert(DepartmentDTO departmentDTO);

	void update(DepartmentDTO departmentDTO);

	void delete(Long id);
}
