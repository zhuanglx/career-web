package com.railway.labor.career.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.dao.EvaluationNormalDAO;
import com.railway.labor.career.model.dto.EvaluationNormalDTO;
import com.railway.labor.career.model.query.EvaluationNormalQuery;

@Service
public class EvaluationNormalService {

	@Autowired
	private EvaluationNormalDAO evaluationNormalDAO;

	public Pagination<EvaluationNormalQuery, EvaluationNormalDTO> query(EvaluationNormalQuery evaluationNormalQuery) {
		return evaluationNormalDAO.query(evaluationNormalQuery);
	}

	public EvaluationNormalDTO get(Long id) {
		return evaluationNormalDAO.get(id);
	}

	public void insert(EvaluationNormalDTO evaluationNormalDTO) {
		evaluationNormalDAO.insert(evaluationNormalDTO);
	}

	public void update(EvaluationNormalDTO evaluationNormalDTO) {
		evaluationNormalDAO.insert(evaluationNormalDTO);
	}

	void delete(Long id) {
		evaluationNormalDAO.delete(id);
	}
}
