package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.BlogService;

@Controller
@RequestMapping(value="/{id}")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@RequestMapping("")
	public String blogMain(@PathVariable("id")String id, HttpSession session) {
		System.out.println("BlogController.blogMain 블로그시작"+id);
		
		blogService.blogMain(id);
		
		return "/blog/blog-main/"+id;
	}
	
	
} // The end of BlogController
