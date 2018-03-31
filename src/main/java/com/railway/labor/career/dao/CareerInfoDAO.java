package com.railway.labor.career.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.mapper.CareerInfoMapper;
import com.railway.labor.career.model.dto.CareerInfoDTO;
import com.railway.labor.career.model.query.CareerInfoQuery;

@Service
public class CareerInfoDAO {
	@Autowired
	private CareerInfoMapper careerInfoMapper;

	public Long count(CareerInfoQuery careerInfoQuery) {
		return careerInfoMapper.count(careerInfoQuery);
	}
	public Pagination<CareerInfoQuery, CareerInfoDTO> query(CareerInfoQuery careerInfoQuery) {
		Pagination<CareerInfoQuery, CareerInfoDTO> pagination = new Pagination<>();
		pagination.setQuery(careerInfoQuery);
    	pagination.setResultTotal(count(careerInfoQuery));
    	List<CareerInfoDTO> careerInfoDTOList = careerInfoMapper.query(careerInfoQuery,pagination);
    	pagination.setRows(careerInfoDTOList);
		
		return pagination;
	}

	public CareerInfoDTO get(Long id) {
		return careerInfoMapper.get(id);
	}

	public void insert(CareerInfoDTO careerInfoDTO) {
		careerInfoMapper.insert(careerInfoDTO);
	}

	public void update(CareerInfoDTO careerInfoDTO) {
		careerInfoMapper.insert(careerInfoDTO);
	}

	public void delete(Long id) {
		careerInfoMapper.delete(id);
	}
}
