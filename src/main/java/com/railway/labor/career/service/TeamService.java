package com.railway.labor.career.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.labor.career.common.Pagination;
import com.railway.labor.career.dao.TeamDAO;
import com.railway.labor.career.model.dto.TeamDTO;
import com.railway.labor.career.model.query.TeamQuery;

@Service
public class TeamService {

	@Autowired
	private TeamDAO teamDAO;

	public Pagination<TeamQuery, TeamDTO> query(TeamQuery teamQuery) {
		return teamDAO.query(teamQuery);
	}

	public TeamDTO get(Long id) {
		return teamDAO.get(id);
	}

	public void insert(TeamDTO teamDTO) {
		teamDAO.insert(teamDTO);
	}

	public void update(TeamDTO teamDTO) {
		teamDAO.insert(teamDTO);
	}

	void delete(Long id) {
		teamDAO.delete(id);
	}
}
