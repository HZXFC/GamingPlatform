package com.gp.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gp.bean.regist_multiBean;
import com.gp.common.ConnectionHelper;
import com.gp.dao.regist_multiDao;

public class regist_multiImpl implements regist_multiDao{

	@Override
	public List<regist_multiBean> query(String str) {
		String sql = "SELECT * FROM `regist_multi` while 1=1 "+str;
		Connection conn=null;
		
		try{
			conn = ConnectionHelper.getConnection();
			Statement state= conn.createStatement();
			ResultSet rs=state.executeQuery(sql);
			List<regist_multiBean> list = new ArrayList<regist_multiBean>();
			
			while(rs.next()){
				regist_multiBean multi = new regist_multiBean();
				multi.setUserID(rs.getInt("userId"));
				multi.setGroupID(rs.getInt("groupId"));
				multi.setMatchID(rs.getInt("matchId"));
				
				list.add(multi);
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
	public boolean add(regist_multiBean multi) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `regist_multi` (`userID`, `matchID`, `groupID`) VALUES ("
				+ "'"
				+ multi.getUserID()
				+ "', '"
				+ multi.getMatchID()
				+ "', '"
				+ multi.getGroupID()
				+ "')";
		
		Connection conn=null;
		try{
			conn = ConnectionHelper.getConnection();
			Statement state= conn.createStatement();
			
			return state.execute(sql);
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectionHelper.close(conn);
		}
		
		return false;
	}

	@Override
	public boolean delete(String str) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM `regist_multi` WHERE 1=1 "+str;
		
		Connection conn=null;
		
		try{
			conn = ConnectionHelper.getConnection();
			Statement state= conn.createStatement();
			
			return state.execute(sql);
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectionHelper.close(conn);
		}
		
		return false;
	}





}
