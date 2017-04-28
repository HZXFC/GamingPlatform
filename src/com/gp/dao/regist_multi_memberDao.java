package com.gp.dao;
import java.util.List;

import com.gp.bean.*;

public interface regist_multi_memberDao {
	//查询
	public List<regist_multi_memberBean> query(String str);
	//添加
	public boolean add(regist_multi_memberBean multi);
	//删除
	public boolean delete(String str);
	//更新
	//不实现
}
