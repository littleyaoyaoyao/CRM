package com.yao.crm.coursetype.dao;

import java.util.List;

import com.yao.crm.coursetype.domain.CrmCourseType;

public interface CourseTypeDao {
	/**
	 * 查询所有
	 * @return
	 */
	public List<CrmCourseType> findAll();
}
