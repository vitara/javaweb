package com.vision.cms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 角色功能 定义了管理员、发布人员、审核人员
 * @author Alienware
 *
 */
@Entity
@Table(name="t_role")
public class Role {
	/**
	 * 角色id
	 */
	private int id;
	/**
	 * 角色的名称
	 */
	private String name;
	/**
	 * 角色的编号,枚举类型
	 */
	private RoleType roleType;
	
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
	@Enumerated(EnumType.STRING)
	@Column(name="role_type")
	public RoleType getRoleType() {
		return roleType;
	}
	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}
	
	public Role() {
	}
	public Role(int id, String name, RoleType roleType) {
		super();
		this.id = id;
		this.name = name;
		this.roleType = roleType;
	}
	
	
	
}
