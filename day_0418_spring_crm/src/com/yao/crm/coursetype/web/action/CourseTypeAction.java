package com.yao.crm.coursetype.web.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

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
		
	
	//---------------------------------------------------------------------
	
	public String addOrEditUI(){
		//都会执行return语句，但是如果是编辑功能，会将findCourseType放入栈顶，方便于信息回显
		if(StringUtils.isNotBlank(this.courseType.getCourseTypeId())){
			CrmCourseType findCourseType = this.courseTypeService.findById(this.courseType.getCourseTypeId());
			ActionContext.getContext().getValueStack().push(findCourseType);
		}
		return "addOrEditUI";
	}
	
	
	public String addOrEdit(){
		this.courseTypeService.addOrEdit(courseType);
		return "addOrEdit";
	}

}
