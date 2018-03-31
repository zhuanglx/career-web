package com.railway.labor.career.model.query;

public class EvaluationAbrogateQuery extends BaseQuery {
	private static final long serialVersionUID = -9190346216450604207L;
	private Long id;
	private String employeeId;
	private String noCommentCondition;
	private String evaluateDate;

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

	public String getNoCommentCondition() {
		return noCommentCondition;
	}

	public void setNoCommentCondition(String noCommentCondition) {
		this.noCommentCondition = noCommentCondition;
	}

	public String getEvaluateDate() {
		return evaluateDate;
	}

	public void setEvaluateDate(String evaluateDate) {
		this.evaluateDate = evaluateDate;
	}
}
