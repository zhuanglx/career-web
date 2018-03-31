package com.railway.labor.career.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.model.dto.CareerInfoDTO;
import com.railway.labor.career.model.query.CareerInfoQuery;

public interface CareerInfoMapper {

	List<CareerInfoDTO> query(@Param("careerInfoQuery") CareerInfoQuery careerInfoQuery, @Param("pagination") Pagination<CareerInfoQuery, CareerInfoDTO> pagination);

	Long count(@Param("careerInfoQuery") CareerInfoQuery careerInfoQuery);

	CareerInfoDTO get(Long id);

	void insert(CareerInfoDTO careerInfoDTO);

	void update(CareerInfoDTO careerInfoDTO);

	void delete(Long id);
}
