package com.railway.labor.career.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.mapper.EvaluationConditionMapper;
import com.railway.labor.career.model.dto.EvaluationConditionDTO;
import com.railway.labor.career.model.query.EvaluationConditionQuery;

@Service
public class EvaluationConditionDAO {
	@Autowired
	private EvaluationConditionMapper evaluationConditionMapper;
	
	public Long count(EvaluationConditionQuery evaluationConditionQuery) {
		return evaluationConditionMapper.count(evaluationConditionQuery);
	}
	public Pagination<EvaluationConditionQuery, EvaluationConditionDTO> query(Pagination<EvaluationConditionQuery, EvaluationConditionDTO> pagination) {
    	pagination.setResultTotal(count(pagination.getQuery()));
    	List<EvaluationConditionDTO> evaluationConditionDTOList = evaluationConditionMapper.query(pagination.getQuery(),pagination);
    	pagination.setRows(evaluationConditionDTOList);
		
		return pagination;
	}

	public EvaluationConditionDTO get(Long id) {
		return evaluationConditionMapper.get(id);
	}

	public void insert(EvaluationConditionDTO evaluationConditionDTO) {
		evaluationConditionMapper.insert(evaluationConditionDTO);
	}

	public void update(EvaluationConditionDTO evaluationConditionDTO) {
		evaluationConditionMapper.insert(evaluationConditionDTO);
	}

	public void delete(Long id) {
		evaluationConditionMapper.delete(id);
	}
}
