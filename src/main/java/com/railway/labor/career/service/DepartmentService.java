package com.railway.labor.career.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.dao.DepartmentDAO;
import com.railway.labor.career.model.dto.DepartmentDTO;
import com.railway.labor.career.model.query.DepartmentQuery;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentDAO departmentDAO;

	public Pagination<DepartmentQuery, DepartmentDTO> query(DepartmentQuery departmentQuery) {
		return departmentDAO.query(departmentQuery);
	}

	public DepartmentDTO get(Long id) {
		return departmentDAO.get(id);
	}

	public void insert(DepartmentDTO departmentDTO) {
		departmentDAO.insert(departmentDTO);
	}

	public void update(DepartmentDTO departmentDTO) {
		departmentDAO.insert(departmentDTO);
	}

	void delete(Long id) {
		departmentDAO.delete(id);
	}
}
