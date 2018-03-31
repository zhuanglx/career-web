package com.railway.labor.career.model.query;

import java.util.Date;

public class EvaluationNormalQuery extends BaseQuery {
	private static final long serialVersionUID = -3330144592859167555L;
	private Long id;
	private String employeeId;
	private Long scoreType;
	private Long scoreName;
	private String firstLevel;
	private String secondLevel;
	private String scoreContent;
	private String score;
	private Date evaluateDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Long getScoreType() {
		return scoreType;
	}

	public void setScoreType(Long scoreType) {
		this.scoreType = scoreType;
	}

	public Long getScoreName() {
		return scoreName;
	}

	public void setScoreName(Long scoreName) {
		this.scoreName = scoreName;
	}

	public String getFirstLevel() {
		return firstLevel;
	}

	public void setFirstLevel(String firstLevel) {
		this.firstLevel = firstLevel;
	}

	public String getSecondLevel() {
		return secondLevel;
	}

	public void setSecondLevel(String secondLevel) {
		this.secondLevel = secondLevel;
	}

	public String getScoreContent() {
		return scoreContent;
	}

	public void setScoreContent(String scoreContent) {
		this.scoreContent = scoreContent;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public Date getEvaluateDate() {
		return evaluateDate;
	}

	public void setEvaluateDate(Date evaluateDate) {
		this.evaluateDate = evaluateDate;
	}
}
