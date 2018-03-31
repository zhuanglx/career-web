package com.railway.labor.career.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.mapper.SysDictMapper;
import com.railway.labor.career.model.dto.SysDictDTO;
import com.railway.labor.career.model.query.SysDictQuery;

@Service
public class SysDictDAO {
	@Autowired
	private SysDictMapper sysDictMapper;

	public Long count(SysDictQuery sysDictQuery) {
		return sysDictMapper.count(sysDictQuery);
	}
	public Pagination<SysDictQuery, SysDictDTO> query(SysDictQuery sysDictQuery) {
		Pagination<SysDictQuery, SysDictDTO> pagination = new Pagination<>();
		pagination.setQuery(sysDictQuery);
    	pagination.setResultTotal(count(sysDictQuery));
    	List<SysDictDTO> sysDictDTOList = sysDictMapper.query(sysDictQuery,pagination);
    	pagination.setRows(sysDictDTOList);
		
		return pagination;
	}

	public SysDictDTO get(Long id) {
		return sysDictMapper.get(id);
	}

	public void insert(SysDictDTO sysDictDTO) {
		sysDictMapper.insert(sysDictDTO);
	}

	public void update(SysDictDTO sysDictDTO) {
		sysDictMapper.insert(sysDictDTO);
	}

	public void delete(Long id) {
		sysDictMapper.delete(id);
	}
}
