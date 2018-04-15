package com.railway.labor.career.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.mapper.CareerInfoMapper;
import com.railway.labor.career.model.dto.CareerInfoDTO;
import com.railway.labor.career.model.query.CareerInfoQuery;

@Service
public class CareerInfoDAO {
	@Autowired
	private CareerInfoMapper careerInfoMapper;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	public Long count(CareerInfoQuery careerInfoQuery) {
		return careerInfoMapper.count(careerInfoQuery);
	}
	public Pagination<CareerInfoQuery, CareerInfoDTO> query(Pagination<CareerInfoQuery, CareerInfoDTO> pagination) {
    	pagination.setResultTotal(count(pagination.getQuery()));
    	List<CareerInfoDTO> careerInfoDTOList = careerInfoMapper.query(pagination.getQuery(),pagination);
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
