package com.railway.labor.career.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.dao.CareerInfoDAO;
import com.railway.labor.career.model.dto.CareerInfoDTO;
import com.railway.labor.career.model.query.CareerInfoQuery;

@Service
public class CareerInfoService {

	@Autowired
	private CareerInfoDAO careerInfoDAO;

	public Pagination<CareerInfoQuery, CareerInfoDTO> query(Pagination<CareerInfoQuery, CareerInfoDTO> pagination) {
		return careerInfoDAO.query(pagination);
	}

	public CareerInfoDTO get(Long id) {
		return careerInfoDAO.get(id);
	}

	public void insert(CareerInfoDTO careerInfoDTO) {
		careerInfoDAO.insert(careerInfoDTO);
	}

	public void update(CareerInfoDTO careerInfoDTO) {
		careerInfoDAO.insert(careerInfoDTO);
	}

	void delete(Long id) {
		careerInfoDAO.delete(id);
	}
}
