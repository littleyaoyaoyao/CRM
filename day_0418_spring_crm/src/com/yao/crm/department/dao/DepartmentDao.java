package com.yao.crm.department.dao;

import java.util.List;

import com.yao.crm.department.domain.CrmDepartment;

public interface DepartmentDao {
	public List<CrmDepartment> findAllDepartments(); 
}
