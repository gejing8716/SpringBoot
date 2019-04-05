package com.rl.ces;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DBUtil {
	
	public static Connection getConn(){
		//获得classpath下的资源文件流
		InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
		Properties prop = new Properties();
		Connection conn = null;
		try {
			prop.load(in);
			//获得数据库连接信息
			String driverClass = prop.getProperty("driverClass");
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			//注册数据库驱动
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static PreparedStatement getPstmt(String sql){
		Connection conn = getConn();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}

	public static void closeResUpdate(PreparedStatement pstmt){
		try {
			if(pstmt != null){
				Connection conn = pstmt.getConnection();
				pstmt.close();
				if(conn != null){
					conn.close();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeResQuery(ResultSet rs){
		try {
			if(rs != null){
				Statement pstmt = rs.getStatement();
				//关闭ResultSet一定要在获得Statement之后
				rs.close();
				if(pstmt != null){
					Connection conn = pstmt.getConnection();
					pstmt.close();
					if(conn != null){
						conn.close();
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
