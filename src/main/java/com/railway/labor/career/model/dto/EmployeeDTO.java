package com.railway.labor.career.model.dto;

/**
 * t_employee
 * 
 * @author zhuanglinxiang
 * 
 */
public class EmployeeDTO extends BaseDTO {

	private static final long serialVersionUID = -8543541663995652230L;
	/**
	 * 主键ID t_employee.collumn id
	 */
	private Long id;
	/**
	 * 工号 t_employee.collumn job_number
	 */
	private String jobNumber;
	/**
	 * 员工姓名 t_employee.collumn name
	 */
	private String name;
	/**
	 * 组id t_employee.collumn id
	 */
	private String teamId;
	/**
	 * '职务id t_employee.collumn position_id
	 */
	private String positionId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

}
