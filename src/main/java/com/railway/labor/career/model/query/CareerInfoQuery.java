package com.railway.labor.career.model.query;

public class CareerInfoQuery extends BaseQuery {
	private static final long serialVersionUID = -2165623370134439441L;
	/**
	 * 员工工号
	 * t_employee.job_number
	 */
	private String employeeJobNumber;
	/**
	 * 员工姓名
	 * t_employee.name
	 */
	private String employeeName;
	/**
	 * 部门名称
	 *  t_department.collumn name
	 */
	private String departmentName;
	/**
	 * 班组
	 * t_team.collumn name
	 */
	private String teamName;
	/**
	 * 评定年度
	 *t_careerInfo.collumn evaluate_year
	 */
	private String evaluateYear;
	/**
	 * 岗位/工种
	 *t_careerInfo.collumn evaluate_year
	 */
	private String typeOfWork;
	/**
	 * 原所属序列
	 *t_careerInfo.collumn evaluate_year
	 */
	private String sequenceOld;
	/**
	 * 原评定等级
	 *t_careerInfo.collumn grade_old
	 */
	private String gradeOld;
	/**
	 * 拟晋升等级
	 *t_careerInfo.collumn grade_old
	 */
	private String quasirating;
	/**
	 * 晋升等级
	 *t_careerInfo.collumn to_quasirating
	 */
	private String toQuasirating;
	public String getEmployeeJobNumber() {
		return employeeJobNumber;
	}
	public void setEmployeeJobNumber(String employeeJobNumber) {
		this.employeeJobNumber = employeeJobNumber;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getEvaluateYear() {
		return evaluateYear;
	}
	public void setEvaluateYear(String evaluateYear) {
		this.evaluateYear = evaluateYear;
	}
	public String getTypeOfWork() {
		return typeOfWork;
	}
	public void setTypeOfWork(String typeOfWork) {
		this.typeOfWork = typeOfWork;
	}
	public String getSequenceOld() {
		return sequenceOld;
	}
	public void setSequenceOld(String sequenceOld) {
		this.sequenceOld = sequenceOld;
	}
	public String getGradeOld() {
		return gradeOld;
	}
	public void setGradeOld(String gradeOld) {
		this.gradeOld = gradeOld;
	}
	public String getQuasirating() {
		return quasirating;
	}
	public void setQuasirating(String quasirating) {
		this.quasirating = quasirating;
	}
	public String getToQuasirating() {
		return toQuasirating;
	}
	public void setToQuasirating(String toQuasirating) {
		this.toQuasirating = toQuasirating;
	}
	
}
