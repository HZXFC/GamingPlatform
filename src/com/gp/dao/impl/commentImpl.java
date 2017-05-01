package com.gp.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gp.bean.commentBean;
import com.gp.common.ConnectionHelper;
import com.gp.dao.commentDao;

public class commentImpl implements commentDao{

	@Override
	public List<commentBean> query(String str) {
		// TODO Auto-generated method stub
		String sql="Select * from comment where  1=1" + str;
		Connection conn=null;
		try{
			conn = ConnectionHelper.getConnection();
			Statement state= conn.createStatement();
			ResultSet rs=state.executeQuery(sql);
			List<commentBean> list = new ArrayList<commentBean>();
			while(rs.next()){
				
				commentBean comment = new commentBean();
				comment.setUserID(rs.getInt("userID"));
				comment.setMatchID(rs.getInt("matchID"));
				comment.setDate(rs.getDate("date").toString());
				comment.setContent(rs.getString("content"));
				list.add(comment);
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectionHelper.close(conn);
		}
		

		return null;
		
		

	}



	@Override
	public boolean add(commentBean comment) {
		// TODO Auto-generated method stub
		String sql="SINSERT INTO `comment` ( `matchID`, `date`, `content`) VALUES ( '"+comment.getMatchID()+"', '"+comment.getDate()+"', '"+comment.getContent()+"')" ;
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
	public void delete(String str) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public boolean update(String str) {
		// TODO Auto-generated method stub
		return false;
	}


}
