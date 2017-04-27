package com.yao.crm.post.dao;

import java.util.List;

import com.yao.crm.department.domain.CrmDepartment;
import com.yao.crm.post.domain.CrmPost;

public interface PostDao {
	public List<CrmPost> findAllPost(CrmDepartment department);
}
