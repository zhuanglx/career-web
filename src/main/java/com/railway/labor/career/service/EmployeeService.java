package com.railway.labor.career.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.dao.EmployeeDAO;
import com.railway.labor.career.model.dto.EmployeeDTO;
import com.railway.labor.career.model.query.EmployeeQuery;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	public Pagination<EmployeeQuery, EmployeeDTO> query(Pagination<EmployeeQuery, EmployeeDTO> pagination) {
		return employeeDAO.query(pagination);
	}

	public EmployeeDTO get(Long id) {
		return employeeDAO.get(id);
	}

	public void insert(EmployeeDTO employeeDTO) {
		employeeDAO.insert(employeeDTO);
	}

	public void update(EmployeeDTO employeeDTO) {
		employeeDAO.insert(employeeDTO);
	}

	void delete(Long id) {
		employeeDAO.delete(id);
	}
}
