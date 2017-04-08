package com.gp.service;

import java.util.List;

import com.gp.bean.gamematchBean;
import com.gp.dao.gamematchDao;
import com.gp.dao.impl.gamematchImpl;


/**
 * 比赛对应的服务类
 * @author FCL
 *
 */
public class matchService {

	gamematchDao gamematchdao = new gamematchImpl();
	
	/**  
	 * 返回静态对象
	 */
	private static final matchService instance = new matchService();
	
	public static matchService getInstance() {
		return instance;
	}
	
	/**
	 * 获取gamematch List
	 * return list;
	 */
	public List<gamematchBean> getMatchs(String gameName){
		return gamematchdao.getMatchs(gameName);
	}
	
	/**
	 * 通过matchID获取gamematchBan
	 * return gamematchbean
	 */
	public gamematchBean getOnematch(int matchID){
		return gamematchdao.getOneMatch(matchID);
	}
	
}
