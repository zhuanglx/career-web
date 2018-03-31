package com.railway.labor.career.model.query;

import java.util.Date;


public class EvaluationPromoteQuery extends BaseQuery {
	private static final long serialVersionUID = -3330144592859167555L;
	private Long id;
	private String employeeId;
	private String promoteCondition;
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
