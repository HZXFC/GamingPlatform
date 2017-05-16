package com.gp.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class Comment{

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	
//	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
//	//@JoinColumn(name="gameMatchId")	
//	@JoinTable(name = "gameMatchCommentList",
//	joinColumns={@JoinColumn(name="commentId",referencedColumnName="id")},
//	inverseJoinColumns={@JoinColumn(name="matchId",referencedColumnName="id")})
//	private GameMatch gamematch;
//	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="userId")	
	@JoinTable(name = "userCommentList",
	joinColumns={@JoinColumn(name="commentId",referencedColumnName="id")},
	inverseJoinColumns={@JoinColumn(name="userId",referencedColumnName="id")})
	private User user;
	
	private Date date;
	
	private String content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public GameMatch getGamematch() {
//		return gamematch;
//	}
//
//	public void setGamematch(GameMatch gamematch) {
//		this.gamematch = gamematch;
//	}



	public String getContent() {
		return content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
