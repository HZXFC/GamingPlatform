package com.gp.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
public class GameMatch {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	private Date startTime;
	
	private int award;
	
	private String area;
	
	private int ruleID;
	
	private int personNum;
	
	private int teamNum; 
	
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	private Date deadline;
	
	private String matchName;
	
	private String matchIMG;

	private String gameName;
//	
//	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
//	@JoinColumn(name="gameMatchId",referencedColumnName="id")
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "gameMatchCommentList",
	joinColumns={@JoinColumn(name="matchId",referencedColumnName="id")},
	inverseJoinColumns={@JoinColumn(name="commentId",referencedColumnName="id")})
	private List<Comment> commentList = new ArrayList<>();

	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name="gameMatchId",referencedColumnName="id")	
	//@OrderBy(value= "id DESC")
	//@OneToMany
	@JoinTable(name = "gameMatchGroupList",
	joinColumns={@JoinColumn(name="matchId",referencedColumnName="id")},
	inverseJoinColumns={@JoinColumn(name="groupId",referencedColumnName="id")})
	private List<RegistGroup> groupList = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAward() {
		return award;
	}

	public void setAward(int award) {
		this.award = award;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getRuleID() {
		return ruleID;
	}

	public void setRuleID(int ruleID) {
		this.ruleID = ruleID;
	}

	public int getPersonNum() {
		return personNum;
	}

	public void setPersonNum(int personNum) {
		this.personNum = personNum;
	}

	public int getTeamNum() {
		return teamNum;
	}

	public void setTeamNum(int teamNum) {
		this.teamNum = teamNum;
	}

	public String getMatchName() {
		return matchName;
	}

	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}

	public String getMatchIMG() {
		return matchIMG;
	}

	public void setMatchIMG(String matchIMG) {
		this.matchIMG = matchIMG;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public List<RegistGroup> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<RegistGroup> groupList) {
		this.groupList = groupList;
	}

	public void addComment(Comment comment){
		this.commentList.add(comment);
	}
	
	public void addGroup(RegistGroup registGroup){
		this.groupList.add(registGroup);
	}
//	public List<Comment> getComment() {
//		return commentList;
//	}
//
//	public void setComment(List<Comment> commentList) {
//		this.commentList = commentList;
//	}
//
//	public List<RegistGroup> getGroup() {
//		return groupList;
//	}
//
//	public void setGroup(List<RegistGroup> group) {
//		this.groupList = group;
//	}
	
	
}
