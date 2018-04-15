package com.railway.labor.career.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.mapper.EvaluationPromoteMapper;
import com.railway.labor.career.model.dto.EvaluationPromoteDTO;
import com.railway.labor.career.model.query.EvaluationPromoteQuery;

@Service
public class EvaluationPromoteDAO {
	@Autowired
	private EvaluationPromoteMapper evaluationPromoteMapper;

	public Long count(EvaluationPromoteQuery evaluationPromoteQuery) {
		return evaluationPromoteMapper.count(evaluationPromoteQuery);
	}
	public Pagination<EvaluationPromoteQuery, EvaluationPromoteDTO> query(Pagination<EvaluationPromoteQuery, EvaluationPromoteDTO> pagination) {
    	pagination.setResultTotal(count(pagination.getQuery()));
    	List<EvaluationPromoteDTO> evaluationPromoteDTOList = evaluationPromoteMapper.query(pagination.getQuery(),pagination);
    	pagination.setRows(evaluationPromoteDTOList);
		
		return pagination;
	}

	public EvaluationPromoteDTO get(Long id) {
		return evaluationPromoteMapper.get(id);
	}

	public void insert(EvaluationPromoteDTO evaluationPromoteDTO) {
		evaluationPromoteMapper.insert(evaluationPromoteDTO);
	}

	public int update(EvaluationPromoteDTO evaluationPromoteDTO) {
		return evaluationPromoteMapper.update(evaluationPromoteDTO);
	}

	public void delete(Long id) {
		evaluationPromoteMapper.delete(id);
	}
}
