package com.railway.labor.career.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.dao.EvaluationAbrogateDAO;
import com.railway.labor.career.model.dto.EvaluationAbrogateDTO;
import com.railway.labor.career.model.query.EvaluationAbrogateQuery;

@Service
public class EvaluationAbrogateService {

	@Autowired
	private EvaluationAbrogateDAO evaluationAbrogateDAO;

	public Pagination<EvaluationAbrogateQuery, EvaluationAbrogateDTO> query(EvaluationAbrogateQuery evaluationAbrogateQuery) {
		return evaluationAbrogateDAO.query(evaluationAbrogateQuery);
	}

	public EvaluationAbrogateDTO get(Long id) {
		return evaluationAbrogateDAO.get(id);
	}

	public void insert(EvaluationAbrogateDTO evaluationAbrogateDTO) {
		evaluationAbrogateDAO.insert(evaluationAbrogateDTO);
	}

	public void update(EvaluationAbrogateDTO evaluationAbrogateDTO) {
		evaluationAbrogateDAO.insert(evaluationAbrogateDTO);
	}

	void delete(Long id) {
		evaluationAbrogateDAO.delete(id);
	}
}
