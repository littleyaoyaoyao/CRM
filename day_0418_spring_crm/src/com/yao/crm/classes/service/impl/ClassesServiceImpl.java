package com.yao.crm.classes.service.impl;

import java.util.List;

import com.yao.crm.classes.dao.ClassesDao;
import com.yao.crm.classes.domain.CrmClasses;
import com.yao.crm.classes.service.ClassesService;

public class ClassesServiceImpl implements ClassesService {

	private ClassesDao classesDao;
	public void setClassesDao(ClassesDao classesDao) {
		this.classesDao = classesDao;
	}
	
	@Override
	public List<CrmClasses> findAll() {
		return this.classesDao.findAll();
	}

	@Override
	public CrmClasses findById(String classId) {
		return this.classesDao.findById(classId);
	}

	@Override
	public void updateUpload(CrmClasses classes) {
		//1.先查询 
		//2.再更新 快照和一级缓存  。hibernate的缓存机制特性，并非是saveOrUpdate的特性
		CrmClasses findClass = this.classesDao.findById(classes.getClassId());
		findClass.setUploadFilename(classes.getUploadFilename());
		findClass.setUploadPath(classes.getUploadPath());
		findClass.setUploadTime(classes.getUploadTime());
	}

}
