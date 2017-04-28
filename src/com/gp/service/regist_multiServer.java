package com.gp.service;

import com.gp.bean.regist_multiBean;
import com.gp.dao.regist_multiDao;
import com.gp.dao.regist_multi_memberDao;
import com.gp.dao.impl.regist_multiImpl;
import com.gp.dao.impl.regist_multi_memberImpl;

public class regist_multiServer {
	regist_multiDao multiDao = new regist_multiImpl();
	regist_multi_memberDao memberDao = new regist_multi_memberImpl();
	private static final regist_multiServer instance = new regist_multiServer(); 
	
	//战队查询（实现方式暂定）
	
	//战队报名
	//创建战队同时要把创建者作为member添加其下
	public boolean  createGroup(){
		
		
		return true;
	}
	
	//取消战队报名
	//取消要把战队其下所有member清除
	
}
