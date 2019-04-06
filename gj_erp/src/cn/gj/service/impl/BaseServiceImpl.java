package cn.gj.service.impl;

import java.lang.reflect.Field;
import java.util.List;

import cn.gj.dao.BaseDao;
import cn.gj.service.BaseService;
import cn.gj.utils.Page;

public class BaseServiceImpl<T , Q> implements BaseService<T, Q> {
	
	BaseDao<T , Q> baseDao;

	@Override
	public void save(T t) {
		baseDao.save(t);
	}

	@Override
	public void update(T t) {
		baseDao.update(t);
	}

	@Override
	public T getObj(Integer id) {
		
		return baseDao.getObj(id);
	}

	@Override
	public void delete(Integer id) {
		baseDao.delete(id);
	}

	@Override
	public void delete(T t) {
		baseDao.delete(t);
	}

	

	@Override
	public List<T> list() {
		return baseDao.list();
	}

	@Override
	public Page queryObjByCondition(Q q, List<String> exclude) {
		Page page = new Page();
		Class<? extends Object> class1 = q.getClass();
		try {
			Field field = class1.getDeclaredField("pageNo");
			field.setAccessible(true);
			Integer pageNo = (Integer) field.get(q);
			page.setPageNo(pageNo);
			Integer startNum = page.getStartNum();
			Field startNumField = class1.getDeclaredField("startNum");
			startNumField.setAccessible(true);
			startNumField.set(q, startNum);
			List<T> list = baseDao.queryObjByCondition(q, exclude);
			page.setList(list);
			Long count = baseDao.queryObjByConditionCount(q, exclude);
			page.setTotalCount(new Integer(count+""));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}

	

}
