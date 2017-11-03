package com.vision.cms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户组对象，使用该对象来获取可以发布文章的栏目信息
 * @author Alienware
 *
 */
@Entity
@Table(name="t_group")
public class Group {
	/**
	 * 组Id
	 */
	private int id;
	/**
	 * 组的名称
	 */
	private String name;
	/**
	 * 组的描述
	 */
	private String descr;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public Group() {
	}
	
	
	public Group(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	
}
