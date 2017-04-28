package com.gp.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gp.bean.regist_multi_memberBean;
import com.gp.common.ConnectionHelper;
import com.gp.dao.regist_multi_memberDao;


public class regist_multi_memberImpl implements regist_multi_memberDao{

	@Override
	public List<regist_multi_memberBean> query(String str) {
		String sql="Select * from regist_multi_member  1=1 " + str;
		Connection conn=null;
		try{
			conn = ConnectionHelper.getConnection();
			Statement state= conn.createStatement();
			ResultSet rs=state.executeQuery(sql);
			List<regist_multi_memberBean> list = new ArrayList<regist_multi_memberBean>();
			while(rs.next()){
				//创建临时对象
				regist_multi_memberBean multi = new regist_multi_memberBean();
				//获取变量值
				multi.setGroupID(rs.getInt("groupID")) ;
				multi.setUserID(rs.getInt("userID"));
				multi.setGameID(rs.getString("gameID"));
				//添加进list
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
	public boolean add(regist_multi_memberBean multi) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `regist_multi_member` (`groupID`, `userID`, `gameID`) VALUES "
				+ "('"+multi.getGroupID()+"', '"+multi.getUserID()+"', '"+multi.getGameID()+"')";
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
		String sql = "DELETE FROM `regist_multi_member` WHERE 1=1 " + str;
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
