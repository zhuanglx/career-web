package com.railway.labor.career.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.mapper.EmployeeMapper;
import com.railway.labor.career.model.dto.EmployeeDTO;
import com.railway.labor.career.model.query.EmployeeQuery;

@Service
public class EmployeeDAO {
	@Autowired
	private EmployeeMapper employeeMapper;
	public Long count(EmployeeQuery employeeQuery) {
		return employeeMapper.count(employeeQuery);
	}
	public Pagination<EmployeeQuery, EmployeeDTO> query(Pagination<EmployeeQuery, EmployeeDTO> pagination) {
    	pagination.setResultTotal(count(pagination.getQuery()));
    	List<EmployeeDTO> employeeDTOList = employeeMapper.query(pagination.getQuery(),pagination);
    	pagination.setRows(employeeDTOList);
		
		return pagination;
	}

	public EmployeeDTO get(Long id) {
		return employeeMapper.get(id);
	}

	public void insert(EmployeeDTO employeeDTO) {
		employeeMapper.insert(employeeDTO);
	}

	public void update(EmployeeDTO employeeDTO) {
		employeeMapper.insert(employeeDTO);
	}

	public void delete(Long id) {
		employeeMapper.delete(id);
	}
}
