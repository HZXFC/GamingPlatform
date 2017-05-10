package com.gp.service;

import com.gp.bean.regist_multiBean;
import com.gp.bean.regist_multi_memberBean;
import com.gp.dao.regist_multiDao;
import com.gp.dao.regist_multi_memberDao;
import com.gp.dao.impl.regist_multiImpl;
import com.gp.dao.impl.regist_multi_memberImpl;

public class regist_multiService {
	regist_multiDao multiDao = new regist_multiImpl();
	regist_multi_memberDao memberDao = new regist_multi_memberImpl();
	private static final regist_multiService instance = new regist_multiService(); 
	
	public static regist_multiService getInstance(){
		return instance;
	}
	
	//战队查询单个
	//
	public regist_multiBean getGroup(int userID,int matchID){
		String str = " and userid="
				+ userID
				+ " and matchid="
				+ matchID;
		
		return multiDao.query(str).get(0);
		
	}
	
	//战队报名
	//创建战队同时要把创建者作为member添加其下
	public boolean  createGroup(int userID ,int matchID ,String gameID){
		//创建group
		regist_multiBean group = new regist_multiBean(); 
		group.setMatchID(matchID);
		group.setUserID(userID);
		
		multiDao.add(group);
		
		int groupID = getGroup(userID,matchID).getGroupID();
		regist_multi_memberBean member = new regist_multi_memberBean();
		member.setGroupID(groupID);
		member.setUserID(userID);
		member.setGameID(gameID);
		
		regist_multi_memberService.getInstance().regist(member);
		
		return true;
	}
	
	//取消战队报名
	//取消要把战队其下所有member清除
	
	public boolean cancelGroup(int groupID){
		String str = " and groupID="
				+ groupID;
		memberDao.delete(str);
		
		
		return multiDao.delete(str);
		
	}
	
}
