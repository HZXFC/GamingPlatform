package com.gp.dao;

import java.util.List;

import com.gp.bean.regist_multiBean;

public interface regist_multiDao {
	//查询
	public List<regist_multiBean> query(String str);
	//添加
	public boolean add(regist_multiBean multi);
	//删除
	public boolean delete(String str);
	//更新
	//不实现
}
