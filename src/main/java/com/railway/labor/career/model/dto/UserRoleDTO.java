package com.railway.labor.career.model.dto;

/**
 * t_user_role
 * 
 * @author zhuanglinxiang
 * 
 */
public class UserRoleDTO extends BaseDTO {
	private static final long serialVersionUID = 6515482162556507903L;
	/**
	 * 主键ID t_user_role.collumn id
	 */
	private Long id;
	/**
	 * 角色id t_user_role.collumn user_id
	 */
	private Long userId;
	/**
	 * 权限id t_user_role.collumn role_id
	 */
	private Long roleId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}
