package com.gp.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gp.bean.userBean;
import com.gp.common.ConnectionHelper;
import com.gp.dao.userDao;

public class userImpl implements userDao{

	@Override
	public List<userBean> query(String str) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM `user` where 1=1 " + str;
		Connection conn=null;
		
		try{
			conn = ConnectionHelper.getConnection();
			Statement state= conn.createStatement();
			ResultSet rs=state.executeQuery(sql);
			
			List<userBean> list = new ArrayList<userBean>();
			
			while(rs.next()){
				
				userBean user = new userBean();
				user.setUserID(rs.getInt("userID"));
				user.setPwd(rs.getString("pwd"));
				user.setUserName(rs.getString("userName"));
				
				list.add(user);
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
	public boolean add(userBean user) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `user` (`pwd`, `userName`) VALUES ('"
				+ user.getPwd()
				+ "', '"
				+ user.getUserName()
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

}
