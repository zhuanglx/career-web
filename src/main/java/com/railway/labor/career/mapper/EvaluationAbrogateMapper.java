package com.railway.labor.career.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.model.dto.EvaluationAbrogateDTO;
import com.railway.labor.career.model.query.EvaluationAbrogateQuery;

public interface EvaluationAbrogateMapper {

	List<EvaluationAbrogateDTO> query(@Param("evaluationAbrogateQuery") EvaluationAbrogateQuery evaluationAbrogateQuery, @Param("pagination") Pagination<EvaluationAbrogateQuery, EvaluationAbrogateDTO> pagination);

	Long count(@Param("evaluationAbrogateQuery") EvaluationAbrogateQuery evaluationAbrogateQuery);

	EvaluationAbrogateDTO get(Long id);

	void insert(EvaluationAbrogateDTO evaluationAbrogateDTO);

	int update(EvaluationAbrogateDTO evaluationAbrogateDTO);

	void delete(Long id);
}
