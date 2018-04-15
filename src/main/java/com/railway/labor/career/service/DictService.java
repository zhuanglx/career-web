package com.railway.labor.career.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.dao.DictDAO;
import com.railway.labor.career.model.dto.DictDTO;
import com.railway.labor.career.model.query.DictQuery;

@Service
public class DictService {

	@Autowired
	private DictDAO dictDAO;

	public Pagination<DictQuery, DictDTO> query(Pagination<DictQuery, DictDTO> pagination) {
		return dictDAO.query(pagination);
	}

	public DictDTO get(Long id) {
		return dictDAO.get(id);
	}

	public void insert(DictDTO dictDTO) {
		dictDAO.insert(dictDTO);
	}

	public int update(DictDTO dictDTO) {
		return dictDAO.update(dictDTO);
	}

	public int delete(DictDTO dictDTO) {
		dictDTO.setDelFlag("1");
		return dictDAO.update(dictDTO);
	}
}
