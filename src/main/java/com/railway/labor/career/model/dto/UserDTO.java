package com.railway.labor.career.model.dto;

import com.railway.labor.career.model.BaseModel;

public class UserDTO extends BaseModel {
	private static final long serialVersionUID = 4967397800781853929L;
	private Long id;
	private String userNo;
	private String userName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
