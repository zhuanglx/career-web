package com.railway.labor.career.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.model.dto.EmployeeDTO;
import com.railway.labor.career.model.query.EmployeeQuery;

public interface EmployeeMapper {

	List<EmployeeDTO> query(@Param("employeeQuery") EmployeeQuery employeeQuery, @Param("pagination") Pagination<EmployeeQuery, EmployeeDTO> pagination);

	Long count(@Param("employeeQuery") EmployeeQuery employeeQuery);

	EmployeeDTO get(Long id);

	void insert(EmployeeDTO employeeDTO);

	void update(EmployeeDTO employeeDTO);

	void delete(Long id);
}
