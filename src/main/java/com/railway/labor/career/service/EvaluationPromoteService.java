package com.railway.labor.career.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.dao.EvaluationPromoteDAO;
import com.railway.labor.career.model.dto.EvaluationPromoteDTO;
import com.railway.labor.career.model.query.EvaluationPromoteQuery;

@Service
public class EvaluationPromoteService {

	@Autowired
	private EvaluationPromoteDAO evaluationPromoteDAO;

	public Pagination<EvaluationPromoteQuery, EvaluationPromoteDTO> query(EvaluationPromoteQuery evaluationPromoteQuery) {
		return evaluationPromoteDAO.query(evaluationPromoteQuery);
	}

	public EvaluationPromoteDTO get(Long id) {
		return evaluationPromoteDAO.get(id);
	}

	public void insert(EvaluationPromoteDTO evaluationPromoteDTO) {
		evaluationPromoteDAO.insert(evaluationPromoteDTO);
	}

	public void update(EvaluationPromoteDTO evaluationPromoteDTO) {
		evaluationPromoteDAO.insert(evaluationPromoteDTO);
	}

	void delete(Long id) {
		evaluationPromoteDAO.delete(id);
	}
}
