package cn.gj.service.impl;

import cn.gj.dao.DepDao;
import cn.gj.model.Dep;
import cn.gj.query.DepQuery;
import cn.gj.service.DepService;

public class DepServiceImpl extends BaseServiceImpl<Dep, DepQuery> implements DepService {

	
	private DepDao depDao;
	
	public void setDepDao(DepDao depDao) {
		this.depDao = depDao;
		this.baseDao = depDao;
	}
}
