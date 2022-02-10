package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BlogService;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	public String getJblog(@RequestParam("id")String blogName) {
		System.out.println("BlogController.jblog 블로그시작"+blogName);
		
		blogService.getJblog(blogName);
		
		return "/jblog/"+blogName;
	}
	
	
} // The end of BlogController
