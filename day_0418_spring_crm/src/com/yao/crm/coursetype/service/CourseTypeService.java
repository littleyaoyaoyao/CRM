package com.yao.crm.coursetype.service;

import java.util.List;

import com.yao.crm.coursetype.domain.CrmCourseType;

public interface CourseTypeService {
	/**
	 * 查询所有
	 * @return
	 */
	public List<CrmCourseType> findAll();
}
