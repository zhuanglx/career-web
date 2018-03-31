package com.railway.labor.career.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.model.dto.EvaluationPromoteDTO;
import com.railway.labor.career.model.query.EvaluationPromoteQuery;

public interface EvaluationPromoteMapper {

	List<EvaluationPromoteDTO> query(@Param("evaluationPromoteQuery") EvaluationPromoteQuery evaluationPromoteQuery, @Param("pagination") Pagination<EvaluationPromoteQuery, EvaluationPromoteDTO> pagination);

	Long count(@Param("evaluationPromoteQuery") EvaluationPromoteQuery evaluationPromoteQuery);

	EvaluationPromoteDTO get(Long id);

	void insert(EvaluationPromoteDTO evaluationPromoteDTO);

	void update(EvaluationPromoteDTO evaluationPromoteDTO);

	void delete(Long id);
}
