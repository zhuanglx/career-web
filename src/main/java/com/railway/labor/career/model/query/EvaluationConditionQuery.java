package com.railway.labor.career.model.query;

public class EvaluationConditionQuery extends BaseQuery {
	private static final long serialVersionUID = 7862383629902035964L;
	private Long id;
	private String name;
	private String content;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
