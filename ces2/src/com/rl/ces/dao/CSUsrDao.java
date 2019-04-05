package com.rl.ces.dao;

import java.util.List;

import com.rl.ces.model.CSUsr;

public interface CSUsrDao {
	
	public void saveUser(CSUsr user);
	
	public void updateUser(CSUsr user);
	
	public CSUsr getUserById(Integer userId);
	
	public List<CSUsr> listUser();
	
	public void deleteUser(Integer userId);

}
