package com.yao.crm.staff.dao;

import java.util.List;

import com.yao.crm.staff.domain.CrmStaff;

public interface StaffDao {
	public CrmStaff find(String loginName , String loginPwd);
	
	public List<CrmStaff> findAll();
	
	public CrmStaff findById(String staffId);
}
