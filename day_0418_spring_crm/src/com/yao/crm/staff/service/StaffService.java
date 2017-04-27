package com.yao.crm.staff.service;

import java.util.List;

import com.yao.crm.staff.domain.CrmStaff;

public interface StaffService {
	public CrmStaff login(CrmStaff staff);
	
	public List<CrmStaff> findAllStaff();
	
	public CrmStaff findById(String staffId);
	
	/**
	 * 更新员工
	 * @param staff
	 */
	public void updateStaff(CrmStaff staff);
}
