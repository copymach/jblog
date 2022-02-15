package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CategoryVo;

@Repository
public class CategoryDao {

	@Autowired
	private SqlSession sqlSession;
	
	public void generateBlogDefault(Map<String, String> cateMap) {
	System.out.println("CategoryDao.generateBlogDefault 블로그 기본값 입력");
	sqlSession.insert("category.generateBlogDefault", cateMap);
	}
	
	
	public List<CategoryVo> getcateList(String id) {
		System.out.println("CategoryDao.getcateList ");
		return sqlSession.selectList("category.getcateList", id);
	}
	
	
} // The end of CategoryDao
