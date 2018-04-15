package com.railway.labor.career.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.mapper.EvaluationNormalMapper;
import com.railway.labor.career.model.dto.EvaluationNormalDTO;
import com.railway.labor.career.model.query.EvaluationNormalQuery;

@Service
public class EvaluationNormalDAO {
	@Autowired
	private EvaluationNormalMapper evaluationNormalMapper;

	public Long count(EvaluationNormalQuery evaluationNormalQuery) {
		return evaluationNormalMapper.count(evaluationNormalQuery);
	}
	public Pagination<EvaluationNormalQuery, EvaluationNormalDTO> query(Pagination<EvaluationNormalQuery, EvaluationNormalDTO> pagination) {
    	pagination.setResultTotal(count(pagination.getQuery()));
    	List<EvaluationNormalDTO> evaluationNormalDTOList = evaluationNormalMapper.query(pagination.getQuery(),pagination);
    	pagination.setRows(evaluationNormalDTOList);
		
		return pagination;
	}

	public EvaluationNormalDTO get(Long id) {
		return evaluationNormalMapper.get(id);
	}

	public void insert(EvaluationNormalDTO evaluationNormalDTO) {
		evaluationNormalMapper.insert(evaluationNormalDTO);
	}

	public int update(EvaluationNormalDTO evaluationNormalDTO) {
		return evaluationNormalMapper.update(evaluationNormalDTO);
	}
	public void delete(Long id) {
		evaluationNormalMapper.delete(id);
	}
}
