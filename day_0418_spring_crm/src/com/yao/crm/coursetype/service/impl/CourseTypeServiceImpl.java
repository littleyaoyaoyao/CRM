package com.yao.crm.coursetype.service.impl;

import java.util.List;

import com.yao.crm.coursetype.dao.CourseTypeDao;
import com.yao.crm.coursetype.domain.CrmCourseType;
import com.yao.crm.coursetype.service.CourseTypeService;

public class CourseTypeServiceImpl implements CourseTypeService{

	private CourseTypeDao courseTypeDao;
	public void setCourseTypeDao(CourseTypeDao courseTypeDao) {
		this.courseTypeDao = courseTypeDao;
	}
	
	@Override
	public List<CrmCourseType> findAll() {
		return courseTypeDao.findAll();
	}
	
}
