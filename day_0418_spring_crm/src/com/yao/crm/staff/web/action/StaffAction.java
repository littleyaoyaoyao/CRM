package com.yao.crm.staff.web.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yao.crm.department.domain.CrmDepartment;
import com.yao.crm.department.service.DepartmentService;
import com.yao.crm.staff.domain.CrmStaff;
import com.yao.crm.staff.service.StaffService;

public class StaffAction extends ActionSupport implements ModelDriven<CrmStaff> {

	private CrmStaff staff = new CrmStaff();

	@Override
	public CrmStaff getModel() {
		// TODO Auto-generated method stub
		return staff;
	}
	
	private StaffService staffService;
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	
	
	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	
	//------------------------------------------------

	public String login(){
		CrmStaff findStaff = staffService.login(staff);
		
		if(findStaff != null){
			ActionContext.getContext().getSession().put("loginStaff", findStaff);
			return "success";
		}
		
		this.addFieldError("", "用户名和密码不匹配");
		return "login";
	}
	
	/**
	 * 显示首页
	 * 
	 */
	public String home(){
		return "home";
	}

	
	/**
	 * 查询所有员工
	 */
	public String findAll(){
		List<CrmStaff> allStaff = staffService.findAllStaff();
		
		ActionContext.getContext().put("allStaff", allStaff);
		
		return "findAll";
	}
	
	public String editUI(){
		//jsp中返回了一个get方法，封装到了staff对象中
		CrmStaff findStaff = this.staffService.findById(staff.getStaffId());
		
		ActionContext.getContext().getValueStack().push(findStaff);
		
		//查询所有部门
		List<CrmDepartment> allDepartment = departmentService.findAllDepartments();
		//存在栈顶，在数据回显的时候从栈顶照下来。因为底层使用的是findValue，会从栈顶先开始找，再找contextMap 。即使在栈顶找到了对象的key是null,也会回显
		ActionContext.getContext().getValueStack().set("allDepartment", allDepartment);
		
		return "editUI";
	}
	
	/**
	 * 编辑更新
	 */
	public String edit(){
		this.staffService.updateStaff(staff);
		return "edit";
	}
}
