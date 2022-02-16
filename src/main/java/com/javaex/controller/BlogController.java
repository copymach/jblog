package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;

@Controller
@RequestMapping(value="/{id}")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@RequestMapping(value="")
	public String blogMain(@PathVariable("id")String id, HttpSession session) {
		System.out.println("BlogController.blogMain 블로그 메인페이지"+id);
		
		// 블로그 아이디 가져오기 
		session.setAttribute("blogInfo", blogService.blogInfo(id));
		return "/blog/blog-main/";
	}
	
	@RequestMapping(value="/admin/basic")
	public String adminBasic() {
		System.out.println("BlogController.adminBasic 관리자페이지 ");
		return "/blog/admin/blog-admin-basic";
	}
	
	@RequestMapping(value="admin/basic/blogDefalut")
	public String blogDefalut(HttpSession session, @ModelAttribute BlogVo blogVo, @RequestParam("file") MultipartFile file) {
		System.out.println("BlogController.blogDefalut 블로그 기본값");
		
		session.setAttribute("blogInfo", blogService.blogDefalut(blogVo, file));
		
		return "redirect:/{id}/admin/basic";
	} // blogDefalut
	
} // The end of BlogController
