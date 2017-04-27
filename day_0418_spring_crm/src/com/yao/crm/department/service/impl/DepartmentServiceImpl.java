package com.yao.crm.department.service.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yao.crm.department.dao.DepartmentDao;
import com.yao.crm.department.domain.CrmDepartment;
import com.yao.crm.department.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentDao departmentDao;
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}


	@Override
	public List<CrmDepartment> findAllDepartments() {
		return departmentDao.findAllDepartments();
	}

}
