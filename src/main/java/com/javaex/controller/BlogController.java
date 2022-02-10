package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BlogService;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	public String jblog(@RequestParam("id")String blogname) {
		System.out.println("BlogController.jblog 블로그시작"+blogname);
		
		return "/jblog/"+blogname;
	}
	
	
} // The end of BlogController
