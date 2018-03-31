package com.railway.labor.career.model.dto;

/**
 * t_role
 * 
 * @author zhuanglinxiang
 * 
 */
public class RoleDTO extends BaseDTO {

	private static final long serialVersionUID = 138356142918465667L;
	/**
	 * 主键ID t_role.collumn id
	 */
	private Long id;
	/**
	 * 角色名称 t_role.collumn name
	 */
	private String name;
	/**
	 * 父角色id t_role.collumn parent_id
	 */
	private Long parentId;
	/**
	 * 角色描述 t_role.collumn descr
	 */
	private Long descr;

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

	public Long getDescr() {
		return descr;
	}

	public void setDescr(Long descr) {
		this.descr = descr;
	}

}
