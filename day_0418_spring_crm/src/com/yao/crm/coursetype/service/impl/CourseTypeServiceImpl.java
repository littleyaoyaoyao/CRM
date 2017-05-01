package com.yao.crm.coursetype.service.impl;

import java.util.ArrayList;
import java.util.List;



import org.apache.commons.lang3.StringUtils;

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

	@Override
	public List<CrmCourseType> findAll(CrmCourseType courseType) {
		//1.1 拼凑条件
		StringBuilder builder = new StringBuilder();
		
		//1.2 拼凑参数，从传递过来的对象中获取参数
		List<Object> paramsList = new ArrayList<Object>();
		
		//***********开始处理传递过来的条件**********
		//课程姓名
		if(StringUtils.isNotBlank(courseType.getCourseName())){
			//like查询：  SELECT * FROM Persons WHERE City LIKE '%lon%'
			builder.append(" and courseName like ?");
			paramsList.add("%" + courseType.getCourseName() + "%");
		}
		
		//课程简介
		if(StringUtils.isNotBlank(courseType.getRemark())){
			builder.append(" and remark like ?");
			paramsList.add("%" + courseType.getRemark() + "%");
		}
		
		
		//总学时：
		if(StringUtils.isNotBlank(courseType.getTotalStart())){
			builder.append(" and total >= ?");
			paramsList.add(Integer.parseInt(courseType.getTotalStart()));
		}
		if(StringUtils.isNotBlank(courseType.getTotalEnd())){
			builder.append(" and total <= ?");
			paramsList.add(Integer.parseInt(courseType.getTotalEnd()));
		}
		
		//收费
		if(StringUtils.isNotBlank(courseType.getCourseCostStart())){
			builder.append(" and courseCost >= ?");
			paramsList.add(Double.parseDouble(courseType.getCourseCostStart()));
		}
		if(StringUtils.isNotBlank(courseType.getCourseCostEnd())){
			builder.append(" and courseCost <= ?");
			paramsList.add(Double.parseDouble(courseType.getCourseCostEnd()));
		}
		
		//**************************************************

		//条件 格式为: and ...? and ...
		String condition = builder.toString();
		
		//实际参数
		Object[] params = paramsList.toArray();
		
		return courseTypeDao.findAll(condition,params);
	}
	
}
