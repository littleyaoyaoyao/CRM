package com.yao.crm.coursetype.dao;

import java.util.List;

import com.yao.crm.coursetype.domain.CrmCourseType;

public interface CourseTypeDao {
	/**
	 * 查询所有
	 * @return
	 */
	public List<CrmCourseType> findAll();

	/**
	 * 按条件查询所有
	 * @param condition
	 * @param params
	 * @return
	 */
	public List<CrmCourseType> findAll(String condition, Object[] params);
	
	
	//---------------编辑和添加功能---------------
	
	/**
	 * 根据课程ID查询
	 * @param courseTypeId
	 * @return
	 */
	public CrmCourseType findById(String courseTypeId);
	
	
	/**
	 * 编辑（先通过id来查找，并用update）和更新(save)
	 * @param courseType
	 */
	public void saveOrUpdate(CrmCourseType courseType);

}
