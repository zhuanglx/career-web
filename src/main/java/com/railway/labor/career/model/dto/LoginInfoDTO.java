package com.railway.labor.career.model.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 登录DTO
 * @author zhuanglinxiang
 *
 */
public class LoginInfoDTO implements Serializable{

	private static final long serialVersionUID = -8510597811497678614L;
	/**
	 * 主键ID t_user.collumn id
	 */
	private Long id;
	/**
	 * 用户账号 t_user.collumn account
	 */
	private String account;
	/**
	 * 用户名称 t_user.collumn name
	 */
	private String name;
	/**
	 * 员工id t_user.collumn employee_id
	 */
	private Long employeeId;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
