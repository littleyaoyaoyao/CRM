package com.yao.crm.post.service;

import java.util.List;

import com.yao.crm.department.domain.CrmDepartment;
import com.yao.crm.post.domain.CrmPost;

public interface PostService {
	public List<CrmPost> findAllPost(CrmDepartment department);
}
