package com.gp.service;

import java.util.List;

import com.gp.bean.gamematchBean;
import com.gp.dao.gamematchDao;
import com.gp.dao.impl.gamematchImpl;


/**
 * ������Ӧ�ķ�����
 * @author FCL
 *
 */
public class matchService {

	gamematchDao gamematchdao = new gamematchImpl();
	
	/**  
	 * ���ؾ�̬����
	 */
	private static final matchService instance = new matchService();
	
	public static matchService getInstance() {
		return instance;
	}
	
	/**
	 * ��ȡgamematch List
	 * return list;
	 */
	public List<gamematchBean> getMatchs(String gameName){
		return gamematchdao.getMatchs(gameName);
	}
	
	/**
	 * ͨ��matchID��ȡgamematchBan
	 * return gamematchbean
	 */
	public gamematchBean getOnematch(int matchID){
		return gamematchdao.getOneMatch(matchID);
	}
	
}
