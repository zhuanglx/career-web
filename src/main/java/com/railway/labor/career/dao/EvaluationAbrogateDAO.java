package com.railway.labor.career.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.mapper.EvaluationAbrogateMapper;
import com.railway.labor.career.model.dto.EvaluationAbrogateDTO;
import com.railway.labor.career.model.query.EvaluationAbrogateQuery;

@Service
public class EvaluationAbrogateDAO {
	@Autowired
	private EvaluationAbrogateMapper evaluationAbrogateMapper;
	
	public Long count(EvaluationAbrogateQuery evaluationAbrogateQuery) {
		return evaluationAbrogateMapper.count(evaluationAbrogateQuery);
	}
	public Pagination<EvaluationAbrogateQuery, EvaluationAbrogateDTO> query(Pagination<EvaluationAbrogateQuery, EvaluationAbrogateDTO> pagination) {
    	pagination.setResultTotal(count(pagination.getQuery()));
    	List<EvaluationAbrogateDTO> evaluationAbrogateDTOList = evaluationAbrogateMapper.query(pagination.getQuery(),pagination);
    	pagination.setRows(evaluationAbrogateDTOList);
		
		return pagination;
	}

	public EvaluationAbrogateDTO get(Long id) {
		return evaluationAbrogateMapper.get(id);
	}

	public void insert(EvaluationAbrogateDTO evaluationAbrogateDTO) {
		evaluationAbrogateMapper.insert(evaluationAbrogateDTO);
	}

	public int update(EvaluationAbrogateDTO evaluationAbrogateDTO) {
		return evaluationAbrogateMapper.update(evaluationAbrogateDTO);
	}

	public void delete(Long id) {
		evaluationAbrogateMapper.delete(id);
	}
}
