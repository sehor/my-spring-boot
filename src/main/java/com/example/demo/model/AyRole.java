package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ay_role database table.
 * 
 */
@Entity
@Table(name="ay_role")
@NamedQuery(name="AyRole.findAll", query="SELECT a FROM AyRole a")
public class AyRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String role;

	public AyRole() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}