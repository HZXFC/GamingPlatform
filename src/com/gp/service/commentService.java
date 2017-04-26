package com.gp.service;



import java.util.List;

import com.gp.bean.commentBean;
import com.gp.dao.commentDao;
import com.gp.dao.impl.commentImpl;

public class commentService {
	commentDao dao = new commentImpl();
	private final static commentService instance = new commentService();
	
	public static commentService getInstance() {
		return instance;
	}
	//添加评论
	public boolean addcomment(commentBean comment){
		return dao.add(comment);
		
	}
	//获取评论
	public List<commentBean> getcomment(int matchID){
		String str=" and matchID = "+matchID;
		
		return dao.query(str);
	}
}
