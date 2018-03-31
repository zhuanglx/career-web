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
	public Pagination<EvaluationAbrogateQuery, EvaluationAbrogateDTO> query(EvaluationAbrogateQuery evaluationAbrogateQuery) {
		Pagination<EvaluationAbrogateQuery, EvaluationAbrogateDTO> pagination = new Pagination<>();
		pagination.setQuery(evaluationAbrogateQuery);
    	pagination.setResultTotal(count(evaluationAbrogateQuery));
    	List<EvaluationAbrogateDTO> evaluationAbrogateDTOList = evaluationAbrogateMapper.query(evaluationAbrogateQuery,pagination);
    	pagination.setRows(evaluationAbrogateDTOList);
		
		return pagination;
	}

	public EvaluationAbrogateDTO get(Long id) {
		return evaluationAbrogateMapper.get(id);
	}

	public void insert(EvaluationAbrogateDTO evaluationAbrogateDTO) {
		evaluationAbrogateMapper.insert(evaluationAbrogateDTO);
	}

	public void update(EvaluationAbrogateDTO evaluationAbrogateDTO) {
		evaluationAbrogateMapper.insert(evaluationAbrogateDTO);
	}

	public void delete(Long id) {
		evaluationAbrogateMapper.delete(id);
	}
}
