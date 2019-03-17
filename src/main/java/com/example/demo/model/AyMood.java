package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ay_mood database table.
 * 
 */
@Entity
@Table(name="ay_mood")
@NamedQuery(name="AyMood.findAll", query="SELECT a FROM AyMood a")
public class AyMood implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String content;

	@Column(name="praise_num")
	private int praiseNum;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="publish_time")
	private Date publishTime;

	@Column(name="user_id")
	private String userId;

	public AyMood() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPraiseNum() {
		return this.praiseNum;
	}

	public void setPraiseNum(int praiseNum) {
		this.praiseNum = praiseNum;
	}

	public Date getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}