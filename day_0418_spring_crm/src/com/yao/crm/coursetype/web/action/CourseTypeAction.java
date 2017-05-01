package com.yao.crm.coursetype.web.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yao.crm.coursetype.domain.CrmCourseType;
import com.yao.crm.coursetype.service.CourseTypeService;

public class CourseTypeAction extends ActionSupport implements ModelDriven<CrmCourseType> {
	
	
	private CrmCourseType courseType = new CrmCourseType();
	
	@Override
	public CrmCourseType getModel() {
		return courseType;
	}
	
	private CourseTypeService courseTypeService;
	public void setCourseTypeService(CourseTypeService courseTypeService) {
		this.courseTypeService = courseTypeService;
	}
	
	//------------------------------------------------------------------
	/**
	 * 查询所有
	 * @return
	 */
	public String findAll(){
//		List<CrmCourseType> allCourseType = this.courseTypeService.findAll();
//		ActionContext.getContext().put("allCourseType", allCourseType);
		
		List<CrmCourseType> allCourseType = this.courseTypeService.findAll(courseType);
		ActionContext.getContext().put("allCourseType", allCourseType);
		
		return "findAll";
	}
		

}
