package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CategoryDao;
import com.javaex.vo.CategoryVo;

@Service
public class CategoryService {

	@Autowired CategoryDao categoryDao;	
	public List<CategoryVo> getcateList(String id) {
		System.out.println("CategoryService.getcateList ");
		return categoryDao.getcateList(id);
	}

	
	
} // The end of CategoryService 
