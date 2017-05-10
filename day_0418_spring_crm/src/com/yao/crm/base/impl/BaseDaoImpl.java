package com.yao.crm.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yao.crm.base.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>{

	//T  编译时，注释变量。在运行时，才可以获得具体的类型
	private Class<?> beanClass;
	public BaseDaoImpl() {
			//获得运行时的类型 , BaseDaoImpl<CrmStaff>被参数化的类型
			ParameterizedType paramType = (ParameterizedType) this.getClass().getGenericSuperclass();
			//获得实际参数的 ,获得所有。此时只有一个
			beanClass = (Class<?>) paramType.getActualTypeArguments()[0];
		}
	
	@Override
	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	@Override
	public void saveOrUpdate(T t) {
		this.getHibernateTemplate().saveOrUpdate(t);
	}

	@Override
	public T findById(Serializable id) {
		return (T) this.getHibernateTemplate().get(beanClass, id);
	}

	@Override
	public List<T> findAll() {
		return this.getHibernateTemplate().find("from " + beanClass.getName());
	}
	

}
