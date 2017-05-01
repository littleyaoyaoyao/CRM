package com.yao.crm.coursetype.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yao.crm.coursetype.dao.CourseTypeDao;
import com.yao.crm.coursetype.domain.CrmCourseType;

public class CourseTypeDaoImpl extends HibernateDaoSupport implements
		CourseTypeDao {

	@Override
	public List<CrmCourseType> findAll() {
		return this.getHibernateTemplate().find("from CrmCourseType");
	}

	@Override
	public List<CrmCourseType> findAll(String condition, Object[] params) {
		String hql="from CrmCourseType where 1=1 "+ condition;
		//因为这部分的find语句条件的特点，所以在action和service中需要这样构造
		return this.getHibernateTemplate().find(hql,params);
	}

}
