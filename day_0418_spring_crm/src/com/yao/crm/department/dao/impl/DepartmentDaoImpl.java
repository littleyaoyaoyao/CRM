package com.yao.crm.department.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateAccessor;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yao.crm.department.dao.DepartmentDao;
import com.yao.crm.department.domain.CrmDepartment;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao{

	@Override
	public List<CrmDepartment> findAllDepartments() {
		return this.getHibernateTemplate().find("from CrmDepartment");
	}
	
}
