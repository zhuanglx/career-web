package com.railway.labor.career.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.mapper.DepartmentMapper;
import com.railway.labor.career.model.dto.DepartmentDTO;
import com.railway.labor.career.model.query.DepartmentQuery;

@Service
public class DepartmentDAO {
	@Autowired
	private DepartmentMapper departmentMapper;

	public Long count(DepartmentQuery departmentQuery) {
		return departmentMapper.count(departmentQuery);
	}
	public Pagination<DepartmentQuery, DepartmentDTO> query(DepartmentQuery departmentQuery) {
		Pagination<DepartmentQuery, DepartmentDTO> pagination = new Pagination<>();
		pagination.setQuery(departmentQuery);
    	pagination.setResultTotal(count(departmentQuery));
    	List<DepartmentDTO> departmentDTOList = departmentMapper.query(departmentQuery,pagination);
    	pagination.setRows(departmentDTOList);
		
		return pagination;
	}

	public DepartmentDTO get(Long id) {
		return departmentMapper.get(id);
	}

	public void insert(DepartmentDTO departmentDTO) {
		departmentMapper.insert(departmentDTO);
	}

	public void update(DepartmentDTO departmentDTO) {
		departmentMapper.insert(departmentDTO);
	}

	public void delete(Long id) {
		departmentMapper.delete(id);
	}
}
