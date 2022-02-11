package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;

@Service
public class BlogService {

	@Autowired
	public BlogDao blogDao;
	
	public String blogMain(String id) {
		System.out.println("BlogService.blogMain ");
		return blogDao.blogMain(id);
		
	}
	
	
} // The end of BlogService
