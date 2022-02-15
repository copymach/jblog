package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.CategoryService;
import com.javaex.vo.CategoryVo;

@Controller
@RequestMapping(value="/{id}/admin/category")
public class CategoryController {

	@Autowired CategoryService categoryService;

	@RequestMapping(value="")
	public String main() {
		System.out.println("CategoryController.main ");
		
		return "/blog/admin/blog-admin-cate";
	}
	
	@RequestMapping(value="")
	public List<CategoryVo> catelist(@RequestParam("id")String id ) {
		System.out.println("CategoryController.catelist");
		
		return categoryService.getcateList(id);
	}
	
	
} // The end of CategoryController 
