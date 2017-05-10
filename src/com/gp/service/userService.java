package com.gp.service;

import com.gp.bean.userBean;
import com.gp.dao.userDao;
import com.gp.dao.impl.userImpl;

public class userService {
	userDao dao = new userImpl();
	
	private static final userService instance = new userService();
	//
	public static userService getInstance(){
		return instance;
	}
	
	//检查用户名是否被注册
	public boolean checkUserName(String userName){
		String str = "and userName="+ userName;
		boolean flag = false;
		int num = dao.query(str).size();
		if(num>0)
			flag = true;
		return flag;
	}
	//用户信息注册
	public boolean register(userBean user){
		 
		
		return dao.add(user);
		
	}
	
	//登录
	//检查用户名和密码
	public boolean canLogin(String userName,String pwd){
		String str = " and userName="+ userName+
					" and pwd="+pwd;
		boolean flag = false;
		int num = dao.query(str).size();
		if(num>0)
			flag = true;
		return flag;
	}
	
}
