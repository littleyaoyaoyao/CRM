package com.yao.crm.classes.web.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.aspectj.util.FileUtil;

import com.yao.crm.base.BaseAction;
import com.yao.crm.classes.domain.CrmClasses;
import com.yao.crm.utils.MyStringUtils;

public class ClassesAction extends BaseAction<CrmClasses> {
	
	/**
	 * 查询所有
	 * @return
	 */
	public String findAll(){
		List<CrmClasses> allClasses = this.getClassesService().findAll();
		this.set("allClasses", allClasses);
		return "findAll";
	}
	
	public String uploadUI(){
		CrmClasses findClasses = this.getClassesService().findById(this.getModel().getClassId());
		this.push(findClasses);
		return "uploadUI";
	}
	
	private File schedule;  //上传的内容
	private String scheduleFileName;  //上传的文件名
	private String scheduleContentType; //上传的文件类型
	
	public void setSchedule(File schedule) {
		this.schedule = schedule;
	}
	public void setScheduleFileName(String scheduleFileName) {
		this.scheduleFileName = scheduleFileName;
	}
	public void setScheduleContentType(String scheduleContentType) {
		this.scheduleContentType = scheduleContentType;
	}

	
	public String upload() throws IOException{
		//保存课表到本地  ----》 修改文件名为随机数，并且没有拓展名 ----》 保存
		//1.1 保存课表到本地 tomcat  .../WEB-INF/upload/...
		String parentDir = ServletActionContext.getServletContext().getRealPath("/WEB-INF/upload");
		//1.2 修改文件名为随机数
		String fileName = MyStringUtils.getUUID();
		//1.3保存
		FileUtil.copyFile(schedule, new File(parentDir, fileName));
		
		//2.更新  若重新上传了课表，需要进行更新
		this.getModel().setUploadTime(new Date());
		this.getModel().setUploadPath("/WEB-INF/upload");
		this.getModel().setUploadFilename(scheduleFileName);
		
		this.getClassesService().updateUpload(this.getModel());
		
		return "upload";
	}
}
