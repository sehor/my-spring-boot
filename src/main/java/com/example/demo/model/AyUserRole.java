package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ay_user_role database table.
 * 
 */
@Entity
@Table(name="ay_user_role")
@NamedQuery(name="AyUserRole.findAll", query="SELECT a FROM AyUserRole a")
public class AyUserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="role_id")
	private String roleId;

	@Column(name="user_id")
	private String userId;

	public AyUserRole() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}