package com.railway.labor.career.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.model.dto.TeamDTO;
import com.railway.labor.career.model.query.TeamQuery;

public interface TeamMapper {

	List<TeamDTO> query(@Param("teamQuery") TeamQuery teamQuery, @Param("pagination") Pagination<TeamQuery, TeamDTO> pagination);

	Long count(@Param("teamQuery") TeamQuery teamQuery);

	TeamDTO get(Long id);

	void insert(TeamDTO teamDTO);

	void update(TeamDTO teamDTO);

	void delete(Long id);
}
