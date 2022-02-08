package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public void join (UserVo userVo) {
		System.out.println("service.join 실행"+userVo);
		userDao.insertUser(userVo);
	} 
	
	
	
} // The end of UserService
