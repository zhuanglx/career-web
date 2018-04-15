package com.railway.labor.career.model.dto;

/**
 * 职业生涯信息表
 * 
 * @author zhuanglinxiang
 * 
 */
public class CareerInfoDTO extends BaseDTO {

	private static final long serialVersionUID = -2815246541097211078L;
	/**
	 * 主键ID
	 */
	private Long id;

	/**
	 * 员工工号 t_employee.job_number
	 */
	private String employeeJobNumber;//
	/**
	 * 员工姓名 t_employee.name
	 */
	private String employeeName;// 姓名
	/**
	 * 部门名称 t_department.collumn name
	 */
	private String departmentName;
	/**
	 * 班组 t_team.collumn name
	 */
	private String teamName;
	/**
	 * 评定年度 t_careerInfo.collumn evaluate_year
	 */
	private String evaluateYear;

	/**
	 * 岗位/工种
	 */
	private String typeOfWork;
	/**
	 * 原所属序列
	 */
	private String sequenceOld;
	/**
	 * 原评定等级
	 */
	private String gradeOld;
	/**
	 * 岗位星级详情
	 */
	private String starDetail;
	/**
	 * 岗位星级积分
	 */
	private String starIntegral;
	/**
	 * 技能等级/职称详情
	 */
	private String skillDetail;
	/**
	 * 技能等级/职称积分
	 */
	private String skillIntegral;
	/**
	 * 发现故障详情
	 */
	private String faultDetail;
	/**
	 * 发现故障积分
	 */
	private String faultIntegral;
	/**
	 * 课题成果详情
	 */
	private String projectDetail;

	/**
	 * 课题成果积分
	 */
	private String projectIntegral;
	/**
	 * 个人荣誉详情
	 */
	private String honorDetail;
	/**
	 * 个人荣誉积分
	 */
	private String honorIntegral;
	/**
	 * 拟晋升等级
	 */
	private String quasirating;
	/**
	 * 晋升等级
	 * 
	 */
	private String toQuasirating;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getStarDetail() {
		return starDetail;
	}

	public void setStarDetail(String starDetail) {
		this.starDetail = starDetail;
	}

	public String getStarIntegral() {
		return starIntegral;
	}

	public void setStarIntegral(String starIntegral) {
		this.starIntegral = starIntegral;
	}

	public String getSkillDetail() {
		return skillDetail;
	}

	public void setSkillDetail(String skillDetail) {
		this.skillDetail = skillDetail;
	}

	public String getSkillIntegral() {
		return skillIntegral;
	}

	public void setSkillIntegral(String skillIntegral) {
		this.skillIntegral = skillIntegral;
	}

	public String getFaultDetail() {
		return faultDetail;
	}

	public void setFaultDetail(String faultDetail) {
		this.faultDetail = faultDetail;
	}

	public String getFaultIntegral() {
		return faultIntegral;
	}

	public void setFaultIntegral(String faultIntegral) {
		this.faultIntegral = faultIntegral;
	}

	public String getProjectDetail() {
		return projectDetail;
	}

	public void setProjectDetail(String projectDetail) {
		this.projectDetail = projectDetail;
	}

	public String getProjectIntegral() {
		return projectIntegral;
	}

	public void setProjectIntegral(String projectIntegral) {
		this.projectIntegral = projectIntegral;
	}

	public String getHonorDetail() {
		return honorDetail;
	}

	public void setHonorDetail(String honorDetail) {
		this.honorDetail = honorDetail;
	}

	public String getHonorIntegral() {
		return honorIntegral;
	}

	public void setHonorIntegral(String honorIntegral) {
		this.honorIntegral = honorIntegral;
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
