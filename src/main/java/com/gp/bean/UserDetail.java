package com.gp.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class UserDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	
//	@OneToOne//(mappedBy="user")
//	//@JoinColumn(name="userId")	
//	private User user ;
	
	private String AdmName;
	
	private String userImg;

	public String getAdmName() {
		return AdmName;
	}

	public void setAdmName(String admName) {
		AdmName = admName;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	
	
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
}
