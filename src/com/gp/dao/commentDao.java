package com.gp.dao;

import com.gp.bean.commentBean;

import java.util.List;

public interface commentDao {
//查询
 public List<commentBean> query(String str);
 //不实现
 public void delete(String str);
 //添加
 public boolean add(commentBean comment);
 //不实现
  public boolean update(String str);

}
 