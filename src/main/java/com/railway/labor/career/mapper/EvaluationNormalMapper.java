package com.railway.labor.career.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.model.dto.EvaluationNormalDTO;
import com.railway.labor.career.model.query.EvaluationNormalQuery;

public interface EvaluationNormalMapper {

	List<EvaluationNormalDTO> query(@Param("evaluationNormalQuery") EvaluationNormalQuery evaluationNormalQuery, @Param("pagination") Pagination<EvaluationNormalQuery, EvaluationNormalDTO> pagination);

	Long count(@Param("evaluationNormalQuery") EvaluationNormalQuery evaluationNormalQuery);

	EvaluationNormalDTO get(Long id);

	void insert(EvaluationNormalDTO evaluationNormalDTO);

	void update(EvaluationNormalDTO evaluationNormalDTO);

	void delete(Long id);
}
