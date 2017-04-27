package com.yao.crm.post.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yao.crm.post.domain.CrmPost;
import com.yao.crm.post.service.PostService;

public class PostAction extends ActionSupport implements ModelDriven<CrmPost> {

	private CrmPost post = new CrmPost();
	
	@Override
	public CrmPost getModel() {
		return post;
	}
	
	private PostService postService ;
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	

	//-------------------------------------------------------------------------------------
	
	/**
	 * ajax通过部门查询所有职务
	 * @return
	 * @throws Exception 
	 */
	public String findAllWithDepartment() throws Exception{
		
		List<CrmPost> allPost = this.postService.findAllPost(post.getDepartment());
		
		//2 将java对象 转换 json数据
		
		//2.1 将不需要的数据排除在外
		JsonConfig jsonConfig =  new JsonConfig();
		jsonConfig.setExcludes(new String[]{"staffSet","department"});
		//2.2 完成转换
		String jsonData = JSONArray.fromObject(allPost, jsonConfig).toString();
		//3.将json数据发送给浏览器
		
		//3.1 设置编码，放置中文乱码 
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		//3.2发送
		ServletActionContext.getResponse().getWriter().print(jsonData);
		
		
		return "none";

		
	}
	
}
