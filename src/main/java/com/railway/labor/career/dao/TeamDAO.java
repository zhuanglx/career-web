package com.railway.labor.career.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.mapper.TeamMapper;
import com.railway.labor.career.model.dto.TeamDTO;
import com.railway.labor.career.model.query.TeamQuery;

@Service
public class TeamDAO {
	@Autowired
	private TeamMapper teamMapper;
	
	public Long count(TeamQuery teamQuery) {
		return teamMapper.count(teamQuery);
	}
	public Pagination<TeamQuery, TeamDTO> query(TeamQuery teamQuery) {
		Pagination<TeamQuery, TeamDTO> pagination = new Pagination<>();
		pagination.setQuery(teamQuery);
    	pagination.setResultTotal(count(teamQuery));
    	List<TeamDTO> teamDTOList = teamMapper.query(teamQuery,pagination);
    	pagination.setRows(teamDTOList);
		
		return pagination;
	}

	public TeamDTO get(Long id) {
		return teamMapper.get(id);
	}

	public void insert(TeamDTO teamDTO) {
		teamMapper.insert(teamDTO);
	}

	public void update(TeamDTO teamDTO) {
		teamMapper.insert(teamDTO);
	}

	public void delete(Long id) {
		teamMapper.delete(id);
	}
}
