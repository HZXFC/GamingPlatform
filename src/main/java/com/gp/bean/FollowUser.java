package com.gp.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FollowUser {

	@Id
    @GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	
	private int userId;
	
	private int followedUserId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFollowedUserId() {
		return followedUserId;
	}

	public void setFollowedUserId(int followedUserId) {
		this.followedUserId = followedUserId;
	}
	
	
}
