package com.railway.labor.career.model.dto;

/**
 * t_evaluation_condition
 * 
 * @author zhuanglinxiang
 * 
 */
public class EvaluationConditionDTO extends BaseDTO {
	private static final long serialVersionUID = 2465444931406380887L;
	/**
	 * 主键ID t_evaluation_normal.collumn id
	 */
	private Long id;
	/**
	 * 条件名称 t_evaluation_normal.collumn name
	 */
	private String name;
	/**
	 * 条件 t_evaluation_normal.collumn content
	 */
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
