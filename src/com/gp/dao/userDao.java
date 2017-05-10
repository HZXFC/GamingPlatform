package com.gp.dao;

import java.util.List;

import com.gp.bean.userBean;

public interface userDao {
	//查询
	public List<userBean> query(String str);
	//添加
	public boolean add(userBean user);
	//删除
	
	//更新
	
	//不实现
	
}
