package com.rl.ces.service.impl;

import java.util.List;

import com.rl.ces.dao.CSUsrDao;
import com.rl.ces.dao.impl.CSUsrDaoImpl;
import com.rl.ces.model.CSUsr;
import com.rl.ces.service.CSUsrService;

public class CSUsrServiceImpl implements CSUsrService {

	private CSUsrDao userDao = new CSUsrDaoImpl();
	
	public CSUsr getUserById(Integer userId) {
		return userDao.getUserById(userId);
	}

	public List<CSUsr> listUser() {
		return userDao.listUser();
	}

	public void saveUser(CSUsr user) {
		userDao.saveUser(user);
	}

	public void updateUser(CSUsr user) {
		userDao.updateUser(user);
	}

	public void deleteUser(Integer userId) {
		userDao.deleteUser(userId);
	}

}
