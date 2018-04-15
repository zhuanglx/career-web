package com.railway.labor.career.model.query;

public class RoleQuery extends BaseQuery {
	private static final long serialVersionUID = 298901188081594436L;
	private Long id;
	private String name;
	private Long parentId;
	private Long userId;
	
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
