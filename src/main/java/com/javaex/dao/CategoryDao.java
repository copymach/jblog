package com.javaex.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao {

	@Autowired
	private SqlSession sqlSession;
	
	public void generateBlogDefault(Map<String, String> cateMap) {
	System.out.println("CategoryDao.generateBlogDefault 블로그 기본값 입력");
	sqlSession.insert("category.generateBlogDefault", cateMap);
	}
	
	
} // The end of CategoryDao
