package com.railway.labor.career.model.dto;

import java.util.Date;

/**
 * t_evaluation_normal
 * 
 * @author zhuanglinxiang
 * 
 */
public class EvaluationPromoteDTO extends BaseDTO {

	private static final long serialVersionUID = 8115513395360426464L;
	/**
	 * 主键ID t_evaluation_normal.collumn id
	 */
	private Long id;
	/**
	 * 员工id t_evaluation_normal.collumn employee_id
	 */
	private String employeeId;
	/**
	 * 破格条件 t_evaluation_normal.collumn promote_condition
	 */
	private String promoteCondition;
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

	public String getPromoteCondition() {
		return promoteCondition;
	}

	public void setPromoteCondition(String promoteCondition) {
		this.promoteCondition = promoteCondition;
	}

	public Date getEvaluateDate() {
		return evaluateDate;
	}

	public void setEvaluateDate(Date evaluateDate) {
		this.evaluateDate = evaluateDate;
	}

}
