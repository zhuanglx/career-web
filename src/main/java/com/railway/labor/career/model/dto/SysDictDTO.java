package com.railway.labor.career.model.dto;

/**
 * t_sys_dict
 * 
 * @author zhuanglinxiang
 * 
 */
public class SysDictDTO extends BaseDTO {
	private static final long serialVersionUID = -6078614049073198912L;
	/**
	 * 主键ID t_sys_dict.collumn id
	 */
	private Long id;
	/**
	 * 名称 t_sys_dict.collumn name
	 */
	private String name;
	/**
	 * 键 t_sys_dict.collumn key
	 */
	private String key;
	/**
	 * 值 t_sys_dict.collumn value
	 */
	private String value;
	/**
	 * 类型 t_sys_dict.collumn type
	 */
	private String type;
	/**
	 * 层级 t_sys_dict.collumn level
	 */
	private String level;
	/**
	 * 分组 t_sys_dict.collumn group
	 */
	private String group;

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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

}
