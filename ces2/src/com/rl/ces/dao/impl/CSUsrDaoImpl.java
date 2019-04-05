package com.rl.ces.dao.impl;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rl.ces.DBUtil;
import com.rl.ces.dao.CSUsrDao;
import com.rl.ces.model.CSUsr;

public class CSUsrDaoImpl implements CSUsrDao {

	public CSUsr getUserById(Integer userId) {
		PreparedStatement pstmt = null;
		String sql = "select * from cs_user where user_id = ?";
		ResultSet rs = null;
		CSUsr user = new CSUsr();
		try{
			pstmt = DBUtil.getPstmt(sql);
			pstmt.setInt(1,userId);
			rs = pstmt.executeQuery();
			rs.next();
			String username = rs.getString("username");
			String password = rs.getString("password");
			Integer gender = rs.getInt("gender");
			java.util.Date birthday = rs.getDate("birthday");
			String address = rs.getString("address");
			BigDecimal sal = rs.getBigDecimal("sal");
			
			user.setUserId(userId);
			user.setUsername(username);
			user.setPassword(password);
			user.setBirthday(birthday);
			user.setAddress(address);
			user.setGender(gender);
			user.setSal(sal);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			DBUtil.closeResQuery(rs);
		}
		return user;
	}

	public List<CSUsr> listUser() {
		String sql = "select * from cs_user";
		PreparedStatement pstmt = DBUtil.getPstmt(sql);
		List<CSUsr> userList = new ArrayList<CSUsr>();
		ResultSet rs = null;
		try{
			rs = pstmt.executeQuery();
			//定义存储user的集合
			while(rs.next()){
				//获得查询上来的每一条数据
				Integer userId = rs.getInt("user_id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				Integer gender = rs.getInt("gender");
				java.util.Date birthday = rs.getDate("birthday");
				String address = rs.getString("address");
				BigDecimal sal = rs.getBigDecimal("sal");
				//封装成user对象
				CSUsr user = new CSUsr();
				user.setUserId(userId);
				user.setUsername(username);
				user.setPassword(password);
				user.setGender(gender);
				user.setBirthday(birthday);
				user.setAddress(address);
				user.setSal(sal);
				userList.add(user);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			DBUtil.closeResQuery(rs);
		}
		return userList;
	}

	public void saveUser(CSUsr user) {
		String sql = "insert into cs_user(user_id, username, password,gender, birthday, address, sal)values(sequserid.nextval, ?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try{
			pstmt = DBUtil.getPstmt(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setInt(3, user.getGender());
			pstmt.setDate(4, new java.sql.Date(user.getBirthday().getTime()));
			pstmt.setString(5, user.getAddress());
			pstmt.setBigDecimal(6, user.getSal());
			pstmt.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			DBUtil.closeResUpdate(pstmt);
		}
	}

	public void updateUser(CSUsr user) {
		String sql = "update cs_user set username = ?, password=?, gender=?, birthday=?, address=?, sal=? where user_id = ?";
		PreparedStatement pstmt = null;
		try{
			pstmt = DBUtil.getPstmt(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setInt(3, user.getGender());
			pstmt.setDate(4, new java.sql.Date(user.getBirthday().getTime()));
			pstmt.setString(5, user.getAddress());
			pstmt.setBigDecimal(6, user.getSal());
			pstmt.setInt(7, user.getUserId());
			pstmt.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			DBUtil.closeResUpdate(pstmt);
		}
	}

	public void deleteUser(Integer userId) {
		//定义添加用户sql
		String sql = "delete cs_user t where t.user_id = ?";
		PreparedStatement pstmt = null;
		try{
			pstmt = DBUtil.getPstmt(sql);
			pstmt.setInt(1, userId);
			pstmt.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			DBUtil.closeResUpdate(pstmt);
		}
	}

}
