package com.yao.crm.base;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	public void save(T t);
	public void delete(T t);
	public void update(T t);
	public void saveOrUpdate(T t);//条件查询的时候用到
	
	public T findById(java.io.Serializable id);
	
	public List<T> findAll();
	
}
