package com.yao.crm.page;

import java.sql.SQLException;
  
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

public class PageHibernateCallback<T> implements HibernateCallback<List<T>> {

	private String hql;
	private Object[] params;
	private int startIndex;
	private int pageSize;
	
	
	
	public PageHibernateCallback(String hql, Object[] params, int startIndex,
			int pageSize) {
		super();
		this.hql = hql;
		this.params = params;
		this.startIndex = startIndex;
		this.pageSize = pageSize;
	}



	@Override
	public List<T> doInHibernate(Session session) throws HibernateException,
			SQLException {
		//1. 通过hql语句获得query对象
		Query queryObject = session.createQuery(hql);
		//2. 条件设置 , 在hql中有几个问号，就会传递过来几个值，循环处理这些值
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				queryObject.setParameter(i, params[i]);
			}
		}
		//3. 分页
		queryObject.setFirstResult(startIndex);
		queryObject.setMaxResults(pageSize);
		
		//4.查询所有
		return queryObject.list();
	}

}
