package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ay_user database table.
 * 
 */
@Entity
@Table(name="ay_user")
@NamedQuery(name="AyUser.findAll", query="SELECT a FROM AyUser a")
public class AyUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String name;

	private String password;

	public AyUser() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AyUser(String id,String name,String password) {
		setId(id); setName(name);setPassword(password);
	}
	
}