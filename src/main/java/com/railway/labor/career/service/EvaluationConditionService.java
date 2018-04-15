package com.railway.labor.career.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.dao.EvaluationConditionDAO;
import com.railway.labor.career.model.dto.EvaluationConditionDTO;
import com.railway.labor.career.model.query.EvaluationConditionQuery;

@Service
public class EvaluationConditionService {

	@Autowired
	private EvaluationConditionDAO evaluationConditionDAO;

	public Pagination<EvaluationConditionQuery, EvaluationConditionDTO> query(Pagination<EvaluationConditionQuery, EvaluationConditionDTO> pagination) {
		return evaluationConditionDAO.query(pagination);
	}

	public EvaluationConditionDTO get(Long id) {
		return evaluationConditionDAO.get(id);
	}

	public void insert(EvaluationConditionDTO evaluationConditionDTO) {
		evaluationConditionDAO.insert(evaluationConditionDTO);
	}

	public void update(EvaluationConditionDTO evaluationConditionDTO) {
		evaluationConditionDAO.insert(evaluationConditionDTO);
	}

	void delete(Long id) {
		evaluationConditionDAO.delete(id);
	}
}
