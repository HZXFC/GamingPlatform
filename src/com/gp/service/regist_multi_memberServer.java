package com.gp.service;

import java.util.List;

import com.gp.bean.regist_multi_memberBean;
import com.gp.dao.regist_multi_memberDao;
import com.gp.dao.impl.regist_multi_memberImpl;

public class regist_multi_memberServer {
	regist_multi_memberDao multiDao = new regist_multi_memberImpl();
	private static final regist_multi_memberServer instance = new regist_multi_memberServer();
	
	public static regist_multi_memberServer getInstance(){
		return instance;
	}
	//获得已报名的成员列表
	public List<regist_multi_memberBean> getMember(int groupID){
		String str = " and groupid ="+groupID;
		
		return multiDao.query(str);
	}
	//接受报名邀请
	public boolean regist(regist_multi_memberBean member){
		
		return multiDao.add(member);
	}
	//个人取消报名
	public boolean cancelRegist(int groupID,int userID){
		String str = " and groupid =  "+groupID + " userid = " + userID;
		return multiDao.delete(str);
	}
	
}
