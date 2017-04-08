package com.gp.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gp.bean.gamematchBean;
import com.gp.dao.gamematchDao;
import com.gp.common.ConnectionHelper;

public class gamematchImpl implements gamematchDao {

	@Override
	public List<String> getGames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<gamematchBean> getMatchs(String gameName) {
		String sql="Select * from gamematch where  1=1";
		Connection conn=null;
		try{
			conn = ConnectionHelper.getConnection();
			Statement state= conn.createStatement();
			ResultSet rs=state.executeQuery(sql); 
			List<gamematchBean> list = new ArrayList<gamematchBean>();
			while (rs.next()) {
				gamematchBean gamematch = new gamematchBean();
				gamematch.setArea(rs.getString("area"));
				gamematch.setAward(rs.getInt("award"));
				gamematch.setDeadline(rs.getString("deadline"));
				gamematch.setMatchID(rs.getInt("matchID"));
				gamematch.setMatchIMG(rs.getString("matchIMG"));
				gamematch.setMatchName(rs.getString("matchName"));
				gamematch.setPersonNum(rs.getInt("personNum"));
				gamematch.setRuleID(rs.getInt("ruleID"));
				gamematch.setStartTime(rs.getString("startTime"));
				gamematch.setTeamNum(rs.getInt("teamNUm"));
				gamematch.setGameName(rs.getString("gameName"));
				list.add(gamematch);
			}
			return list;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectionHelper.close(conn);
		}
		

		return null;
	}

	@Override
	public boolean addMatch() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public gamematchBean getOneMatch(int matchID) {
		String sql = "Select * from gamematch where  matchID = "+matchID;
		Connection conn=null;
		try{
			conn = ConnectionHelper.getConnection();
			Statement state= conn.createStatement();
			ResultSet rs=state.executeQuery(sql);
			gamematchBean gamematch = new gamematchBean();
			while (rs.next()) {
				gamematch.setArea(rs.getString("area"));
				gamematch.setAward(rs.getInt("award"));
				gamematch.setDeadline(rs.getString("deadline"));
				gamematch.setMatchID(rs.getInt("matchID"));
				gamematch.setMatchIMG(rs.getString("matchIMG"));
				gamematch.setMatchName(rs.getString("matchName"));
				gamematch.setPersonNum(rs.getInt("personNum"));
				gamematch.setRuleID(rs.getInt("ruleID"));
				gamematch.setStartTime(rs.getString("startTime"));
				gamematch.setTeamNum(rs.getInt("teamNUm"));
				gamematch.setGameName(rs.getString("gameName"));
			}
			return gamematch;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectionHelper.close(conn);
		}
		
		return null;
	}

}
