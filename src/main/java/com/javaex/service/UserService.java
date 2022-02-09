package com.javaex.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.CategoryDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private BlogDao blogDao;
	@Autowired
	private CategoryDao cateDao;
	
	
	public void join (UserVo userVo) {
		System.out.println("service.join 실행"+userVo);
		userDao.insertUser(userVo);
//		userDao.insertNewBlog(userVo);
		
//		블로그 생성
		Map<String, String> blogMap = new HashMap<String, String>();
		blogMap.put("blogId", userVo.getId());
		blogMap.put("blogTitle", userVo.getUserName());
		blogMap.put("logoFile", "");
		blogDao.generateBlog(blogMap);
		
//		생성한 블로그 기본값
		Map<String, String> cateMap = new HashMap<String, String>();
		cateMap.put(null, null);
		cateMap.put(null, null);
		cateMap.put(null, null);
		cateDao.generateBlogDefault(cateMap);
	} 

	
	public UserVo login(UserVo userVo) {
		System.out.println("service.login 실행 "+userVo);
		UserVo authUser = userDao.selectUser(userVo);
		return authUser;
	}
	
} // The end of UserService
