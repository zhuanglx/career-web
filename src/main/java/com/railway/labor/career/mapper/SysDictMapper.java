package com.railway.labor.career.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.model.dto.SysDictDTO;
import com.railway.labor.career.model.query.SysDictQuery;

public interface SysDictMapper {


	List<SysDictDTO> query(@Param("sysDictQuery") SysDictQuery sysDictQuery, @Param("pagination") Pagination<SysDictQuery, SysDictDTO> pagination);

	Long count(@Param("sysDictQuery") SysDictQuery sysDictQuery);

	SysDictDTO get(Long id);

	void insert(SysDictDTO sysDictDTO);

	void update(SysDictDTO sysDictDTO);

	void delete(Long id);
}
