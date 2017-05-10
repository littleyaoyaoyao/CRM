package com.yao.crm.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yao.crm.classes.service.ClassesService;
import com.yao.crm.coursetype.service.CourseTypeService;
import com.yao.crm.department.service.DepartmentService;
import com.yao.crm.post.service.PostService;
import com.yao.crm.staff.service.StaffService;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{

	private T t;
	
	@Override
	public T getModel() {
		return  t;
	}

	//按照之前对Action的处理，现在没有new一个新的对象，所以需要处理t
	
	//实例化t
	public BaseAction(){
		try {
			//1 获得T运行时Class
			ParameterizedType paramType = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>) paramType.getActualTypeArguments()[0];
				t = clazz.newInstance();
		} catch (Exception e) {
				e.printStackTrace();
		} 
	}
	
	
	//2.spring注入service , 包括Staff CourseType Post Department Classes
	//setter的目的 : 为了让spring进行注入(DI)
	//getter的目的 : 在子类中获得Service对象，即获得spring注入的对象
	//员工
	private StaffService staffService;
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	public StaffService getStaffService() {
		return staffService;
	}
	
	//职务
	private PostService postService;
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	public PostService getPostService() {
		return postService;
	}
	
	//部门
	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	
	//课程类别
	private CourseTypeService courseTypeService;
	public void setCourseTypeService(CourseTypeService courseTypeService) {
		this.courseTypeService = courseTypeService;
	}
	public CourseTypeService getCourseTypeService() {
		return courseTypeService;
	}
	
	//班级
	public ClassesService classesService;
	public void setClassesService(ClassesService classesService) {
		this.classesService = classesService;
	}
	public ClassesService getClassesService() {
		return classesService;
	}
	
	//3.分页数据
	//当前页
	private int pageNum = 1;
	//每页的数据条数
	private int pageSize = 2;
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	//4.值栈操作，三种 contextmap(put) valuestack(push , set)
	public void put(String key , Object value){
		ActionContext.getContext().put(key, value);
	}
	
	public void push(Object o){
		ActionContext.getContext().getValueStack().push(o);
	}
	
	public void set(String key , Object value){
		ActionContext.getContext().getValueStack().set(key, value);
	}
}
