package com.yao.crm.classes.service;

import java.util.List;

import com.yao.crm.classes.domain.CrmClasses;

public interface ClassesService {
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<CrmClasses> findAll();
	
	/**
	 * 通过ID查询详情
	 * @param classId
	 * @return
	 */
	public CrmClasses findById(String classId);
	
	
	/**
	 * 更新上传
	 * @param model
	 */
	public void updateUpload(CrmClasses model);
}
