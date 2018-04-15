package com.railway.labor.career.model.dto;

import java.util.Date;

/**
 * t_evaluation_abrogate
 * 
 * @author zhuanglinxiang
 * 
 */
public class EvaluationAbrogateDTO extends BaseDTO {
	private static final long serialVersionUID = -3930448306156171126L;
	/**
	 * 主键ID t_evaluation_normal.collumn id
	 */
	private Long id;
	/**
	 * 员工id t_evaluation_normal.collumn employee_id
	 */
	private Long employeeId;
	/**
	 * 不参评条件 t_evaluation_normal.collumn no_comment_condition
	 */
	private String noCommentCondition;
	/**
	 * 评定日期 t_evaluation_normal.collumn evaluate_date
	 */
	private Date evaluateDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getNoCommentCondition() {
		return noCommentCondition;
	}

	public void setNoCommentCondition(String noCommentCondition) {
		this.noCommentCondition = noCommentCondition;
	}

	public Date getEvaluateDate() {
		return evaluateDate;
	}

	public void setEvaluateDate(Date evaluateDate) {
		this.evaluateDate = evaluateDate;
	}

}
