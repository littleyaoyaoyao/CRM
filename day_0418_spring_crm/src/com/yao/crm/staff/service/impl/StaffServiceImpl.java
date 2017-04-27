package com.yao.crm.staff.service.impl;

import java.util.List;

import com.yao.crm.staff.dao.StaffDao;
import com.yao.crm.staff.domain.CrmStaff;
import com.yao.crm.staff.service.StaffService;
import com.yao.crm.utils.MyStringUtils;

public class StaffServiceImpl implements StaffService {
	
	private StaffDao staffDao;
	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}


	@Override
	public CrmStaff login(CrmStaff staff) {
		//TODO MD5加密
		String loginPwd = MyStringUtils.getMD5Value(staff.getLoginPwd());
		return staffDao.find(staff.getLoginName(), loginPwd);
	}


	@Override
	/**
	 * 查询所有员工
	 */
	public List<CrmStaff> findAllStaff() {
		return this.staffDao.findAll();
	}


	/**
	 * 根据staffId查询员工
	 */
	public CrmStaff findById(String staffId) {
		return this.staffDao.findById(staffId);
	}


	/**
	 * 更新员工
	 */
	public void updateStaff(CrmStaff staff) {
		CrmStaff findStaff = staffDao.findById(staff.getStaffId());
		
		if(! findStaff.getLoginPwd().equals(staff.getLoginPwd())){
			findStaff.setLoginPwd(MyStringUtils.getMD5Value(staff.getStaffId()));
		}
		findStaff.setLoginName(staff.getLoginName());
		findStaff.setGender(staff.getGender());
		findStaff.setStaffName(staff.getStaffName());
		findStaff.setOnDutyDate(staff.getOnDutyDate());
		findStaff.setPost(staff.getPost());
	}

}
