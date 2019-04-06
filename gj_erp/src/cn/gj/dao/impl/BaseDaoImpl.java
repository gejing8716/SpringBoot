package cn.gj.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.gj.dao.BaseDao;

public abstract class BaseDaoImpl<T , Q> extends HibernateDaoSupport implements BaseDao<T, Q> {

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list() {
		Class<?> class1 = getGenericClass();
		String hql = "from "+class1.getName();
		return this.getHibernateTemplate().find(hql);
	}
	
	@Override
	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	public Class<?> getGenericClass(){
		Type genericSuperclass = this.getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) genericSuperclass;
		Type[] actualTypeArguments = pt.getActualTypeArguments();
		Class<?> class1 = (Class<?>) actualTypeArguments[0];
		return class1;
	}
	@SuppressWarnings("unchecked")
	@Override
	public T getObj(Integer id) {
		Class<?> class1 = getGenericClass();
		return (T) this.getHibernateTemplate().get(class1, id);
	}

	@Override
	public void delete(Integer id) {
		T obj = getObj(id);
		this.getHibernateTemplate().delete(obj);
	}

	@Override
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	@Override
	public List<T> queryObjByCondition(final Q q, final List<String> exclude) {
		@SuppressWarnings("unchecked")
		List<T> tList = this.getHibernateTemplate().executeFind(new HibernateCallback<List<T>>() {
			/**
			 * Session是spring开启的代理session，可以自动的开事务，提交事务和关闭session
			 */
			@Override
			public List<T> doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = creatHql(q);
				//创建查询对象
				Query query = session.createQuery(hql);
				setDynamicParam(query, q, exclude);
				Class<? extends Object> class1 = q.getClass();
				Object object = null;
				try {
					Field startNumField = class1.getDeclaredField("startNum");
					startNumField.setAccessible(true);
					object = startNumField.get(q);
				} catch (Exception e) {
					e.printStackTrace();
				}
				List<T> list = (List<T>)query.setFirstResult((Integer) object).setMaxResults(5).list();
				return list;
			}
		});
		return tList;
	}
	@Override
	public Long queryObjByConditionCount(final Q q, final List<String> exclude) {
		Long totalCount = this.getHibernateTemplate().execute(new HibernateCallback<Long>() {
			/**
			 * Session是spring开启的代理session，可以自动的开事务，提交事务和关闭session
			 */
			@Override
			public Long doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = creatHqlCount(q);
				//创建查询对象
				Query query = session.createQuery(hql);
				setDynamicParam(query, q, exclude);
				Long count = (Long) query.uniqueResult();
				return count;
			}
		});
		return totalCount;
	}
	
	public abstract String creatHql(Q q);
	
	public abstract String creatHqlCount(Q q);
	
	public abstract String creatHqlCondition(Q q);
	
	public void setDynamicParam(Query query , Q q, List<String> exclude){
		Class<? extends Object> class1 = q.getClass();
		Field[] fields = class1.getDeclaredFields();
		Field[] supperFields = class1.getSuperclass().getDeclaredFields();
		List<Field> list1 = Arrays.asList(fields);
		List<Field> list2 = Arrays.asList(supperFields);
		ArrayList<Field> fList = new ArrayList<Field>();
		fList.addAll(list1);
		fList.addAll(list2);
		for(Field f : fList){
			String fieldName = f.getName();
			if(exclude != null && exclude.contains(fieldName)){
				continue;
			}
			Object val = null;
			try {
				f.setAccessible(true);
				val = f.get(q);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			if(val != null){
				if(val.getClass()==String.class){
					if(StringUtils.isNotBlank(val.toString())){
						query.setParameter(fieldName, "%"+val+"%");
					}
				}else {
					query.setParameter(fieldName, val);
				}
			}
		}
	}

}
