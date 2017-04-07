package com.common;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;

public class DBUtils {
	
	public static Connection getConnection(){
		
		Connection conn = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:mysql://localhost:3307/database?characterEncoding=utf8&useSSL=true";
			String username = "root";
			String pwd = "";
			conn = DriverManager.getConnection(url, username, pwd);
			
		}catch(ClassNotFoundException e){
			System.out.println("’“≤ªµΩ¿‡");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	
}