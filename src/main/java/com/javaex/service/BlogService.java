package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;

@Service
public class BlogService {

	@Autowired
	public BlogDao blogDao;
	
	public String getJblog(String blogName) {
		System.out.println("getJblog");
		return blogDao.getJblog(blogName);
		
	}
	
	
} // The end of BlogService
