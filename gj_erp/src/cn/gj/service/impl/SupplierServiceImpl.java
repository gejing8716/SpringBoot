package cn.gj.service.impl;

import cn.gj.dao.SupplierDao;
import cn.gj.model.Supplier;
import cn.gj.query.SupplierQuery;
import cn.gj.service.SupplierService;

public class SupplierServiceImpl extends BaseServiceImpl<Supplier, SupplierQuery> implements SupplierService {

	
	private SupplierDao supplierDao;
	
	public void setSupplierDao(SupplierDao supplierDao) {
		this.supplierDao = supplierDao;
		this.baseDao = supplierDao;
	}
}
