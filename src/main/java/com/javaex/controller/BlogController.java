package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.javaex.service.BlogService;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	public String jblog() {
		System.out.println("BlogController.jblog 블로그시작");
		
		return "";
	}
	
	
} // The end of BlogController
