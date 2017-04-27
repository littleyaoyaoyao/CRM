package com.yao.crm.post.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.yao.crm.department.domain.CrmDepartment;
import com.yao.crm.post.dao.PostDao;
import com.yao.crm.post.domain.CrmPost;

public class PostDaoImpl extends HibernateDaoSupport implements PostDao {

	@Override
	public List<CrmPost> findAllPost(CrmDepartment department) {
		//hibernate是面向对象的
		return this.getHibernateTemplate().find("from CrmPost where department = ?", department);
	}

}
