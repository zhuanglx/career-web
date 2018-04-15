package com.railway.labor.career.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.model.dto.DictDTO;
import com.railway.labor.career.model.query.DictQuery;

public interface DictMapper {


	List<DictDTO> query(@Param("dictQuery") DictQuery dictQuery, @Param("pagination") Pagination<DictQuery, DictDTO> pagination);

	Long count(@Param("dictQuery") DictQuery dictQuery);

	DictDTO get(Long id);

	void insert(DictDTO dictDTO);

	int update(DictDTO dictDTO);

	void delete(Long id);
}
