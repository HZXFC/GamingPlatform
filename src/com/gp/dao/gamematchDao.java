package com.gp.dao;

import java.util.List;
import com.gp.bean.gamematchBean;

public interface gamematchDao {

	//��ȡ������Ϸ����
	public List<String> getGames();
	
	//��ȡĳһ��Ϸ�����б���
	public List<gamematchBean> getMatchs(String gameName);
	
	//��ȡһ��������ϸ��Ϣ
	public gamematchBean getOneMatch(int matchID);
	
	//��ӱ���
	public boolean addMatch();
	 
	
}
