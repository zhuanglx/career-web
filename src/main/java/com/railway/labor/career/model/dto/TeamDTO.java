package com.railway.labor.career.model.dto;

/**
 * t_team
 * 
 * @author zhuanglinxiang
 * 
 */
public class TeamDTO extends BaseDTO {
	private static final long serialVersionUID = 8698898877017902081L;
	/**
	 * 主键ID t_team.collumn id
	 */
	private Long id;
	/**
	 * 组名称 t_team.collumn name
	 */
	private String name;
	/**
	 * 父组id t_team.collumn parent_id
	 */
	private Long parentId;
	/**
	 * 部门id t_team.collumn department_id
	 */
	private Long departmentId;
	/**
	 * 组描述 t_team.collumn descr
	 */
	private String descr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

}
