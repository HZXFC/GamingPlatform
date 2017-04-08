package com.gp.dao;

import java.util.List;
import com.gp.bean.gamematchBean;

public interface gamematchDao {

	//获取所有游戏名称
	public List<String> getGames();
	
	//获取某一游戏的所有比赛
	public List<gamematchBean> getMatchs(String gameName);
	
	//获取一个比赛详细信息
	public gamematchBean getOneMatch(int matchID);
	
	//添加比赛
	public boolean addMatch();
	 
	
}
