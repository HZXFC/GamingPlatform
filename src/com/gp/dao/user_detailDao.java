package com.gp.dao;

import java.util.List;

import com.gp.bean.user_detailBean;

public interface user_detailDao {
	//查询
	public List<user_detailBean> query();
	//添加
	public boolean add();
	//修改
	public boolean update();
	
}
