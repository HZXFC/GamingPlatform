package com.gp.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {

	@Id
    @GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	
	private String userName;
	
	@JsonIgnore
	private String password;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="userDetailId")	
	private UserDetail user_detail;

//	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
//	@JoinTable(name = "groupMember",
//	joinColumns={@JoinColumn(name="userId",referencedColumnName="id")},
//	inverseJoinColumns={@JoinColumn(name="groupId",referencedColumnName="id")})
//	private List<RegistGroup> groupList = new ArrayList<>();
	
//	@OneToMany
////	@JoinTable(name = "ref_user_comment",
////	joinColumns={@JoinColumn(name="userId",referencedColumnName="id")},
////	inverseJoinColumns={@JoinColumn(name="commentId",referencedColumnName="id")})
//	//@OneToMany
//	@JoinTable(name = "userCommentList",
//	joinColumns={@JoinColumn(name="userId",referencedColumnName="id")},
//	inverseJoinColumns={@JoinColumn(name="commentId",referencedColumnName="id")})
//	private List<Comment> commentList = new ArrayList<>();
	public User  (){
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDetail getUser_detail() {
		return user_detail;
	}

	public void setUser_detail(UserDetail user_detail) {
		this.user_detail = user_detail;
	}

//	public List<RegistGroup> getGroupList() {
//		return groupList;
//	}
//
//	public void setGroupList(List<RegistGroup> groupList) {
//		this.groupList = groupList;
//	}
//
//	public List<Comment> getCommentList() {
//		return commentList;
//	}
//
//	public void setCommentList(List<Comment> commentList) {
//		this.commentList = commentList;
//	}


	
}
