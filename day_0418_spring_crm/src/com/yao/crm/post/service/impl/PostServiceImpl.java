package com.yao.crm.post.service.impl;

import java.util.List;

import com.yao.crm.department.domain.CrmDepartment;
import com.yao.crm.post.dao.PostDao;
import com.yao.crm.post.domain.CrmPost;
import com.yao.crm.post.service.PostService;

public class PostServiceImpl implements PostService {
	
	private PostDao postDao;

	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}

	@Override
	public List<CrmPost> findAllPost(CrmDepartment department) {
		return postDao.findAllPost(department);
	}

}
