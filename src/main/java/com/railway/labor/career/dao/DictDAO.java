package com.railway.labor.career.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.mapper.DictMapper;
import com.railway.labor.career.model.dto.DictDTO;
import com.railway.labor.career.model.query.DictQuery;

@Service
public class DictDAO {
	@Autowired
	private DictMapper dictMapper;

	public Long count(DictQuery dictQuery) {
		return dictMapper.count(dictQuery);
	}
	public Pagination<DictQuery, DictDTO> query(Pagination<DictQuery, DictDTO> pagination) {
    	pagination.setResultTotal(count(pagination.getQuery()));
    	List<DictDTO> dictDTOList = dictMapper.query(pagination.getQuery(),pagination);
    	pagination.setRows(dictDTOList);
		
		return pagination;
	}

	public DictDTO get(Long id) {
		return dictMapper.get(id);
	}

	public void insert(DictDTO dictDTO) {
		dictMapper.insert(dictDTO);
	}

	public int update(DictDTO dictDTO) {
		return dictMapper.update(dictDTO);
	}

	public void delete(Long id) {
		dictMapper.delete(id);
	}
}
