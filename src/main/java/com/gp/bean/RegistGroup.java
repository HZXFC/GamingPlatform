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
import javax.persistence.ManyToOne;

@Entity
public class RegistGroup {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	
	private String groupName;
	
//	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
//	//@JoinColumn(name="gameMatchId")	
//	@JoinTable(name = "gameMatchGroupList",
//	joinColumns={@JoinColumn(name="groupId",referencedColumnName="id")},
//	inverseJoinColumns={@JoinColumn(name="matchId",referencedColumnName="id")})
//	private GameMatch gamematch;

	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name = "groupMember",
	joinColumns={@JoinColumn(name="groupId",referencedColumnName="id")},
	inverseJoinColumns={@JoinColumn(name="userId",referencedColumnName="id")})
	private List<User> userList = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public void addUser(User user){
		this.userList.add(user);
	}



	
}
