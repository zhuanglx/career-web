package com.railway.labor.career.model.dto;

import java.util.Date;

/**
 * t_evaluation_normal
 * @author zhuanglinxiang
 *
 */
public class EvaluationNormalDTO  extends BaseDTO {
	private static final long serialVersionUID = -8437974953024727079L;
	/**
	 * 主键ID t_evaluation_normal.collumn id
	 */
	private Long id;
	/**
	 * 员工id t_evaluation_normal.collumn employee_id
	 */
	private String employeeId;
	/**
	 * 积分分类 t_evaluation_normal.collumn score_type
	 */
	private Long scoreType;
	/**
	 * 积分名称 t_evaluation_normal.collumn score_name
	 */
	private Long scoreName;
	/**
	 * 一级标准 t_evaluation_normal.collumn first_level
	 */
	private String firstLevel;
	/**
	 * 二级标准 t_evaluation_normal.collumn second_level
	 */
	private String secondLevel;
	/**
	 * 积分内容 t_evaluation_normal.collumn score_content
	 */
	private String scoreContent;
	/**
	 * 积分分数 t_evaluation_normal.collumn score
	 */
	private String score;
	/**
	 * 主键ID t_evaluation_normal.collumn evaluate_date
	 */
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
