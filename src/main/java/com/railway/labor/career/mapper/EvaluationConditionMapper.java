package com.railway.labor.career.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.model.dto.EvaluationConditionDTO;
import com.railway.labor.career.model.query.EvaluationConditionQuery;

public interface EvaluationConditionMapper {

	List<EvaluationConditionDTO> query(@Param("evaluationConditionQuery") EvaluationConditionQuery evaluationConditionQuery, @Param("pagination") Pagination<EvaluationConditionQuery, EvaluationConditionDTO> pagination);

	Long count(@Param("evaluationConditionQuery") EvaluationConditionQuery evaluationConditionQuery);

	EvaluationConditionDTO get(Long id);

	void insert(EvaluationConditionDTO evaluationConditionDTO);

	void update(EvaluationConditionDTO evaluationConditionDTO);

	void delete(Long id);
}
