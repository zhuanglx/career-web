package com.railway.labor.career.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.dao.SysDictDAO;
import com.railway.labor.career.model.dto.SysDictDTO;
import com.railway.labor.career.model.query.SysDictQuery;

@Service
public class SysDictService {

	@Autowired
	private SysDictDAO sysDictDAO;

	public Pagination<SysDictQuery, SysDictDTO> query(SysDictQuery sysDictQuery) {
		return sysDictDAO.query(sysDictQuery);
	}

	public SysDictDTO get(Long id) {
		return sysDictDAO.get(id);
	}

	public void insert(SysDictDTO sysDictDTO) {
		sysDictDAO.insert(sysDictDTO);
	}

	public void update(SysDictDTO sysDictDTO) {
		sysDictDAO.insert(sysDictDTO);
	}

	void delete(Long id) {
		sysDictDAO.delete(id);
	}
}
