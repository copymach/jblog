package com.javaex.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;

@Repository
public class BlogDao {

	@Autowired
	private SqlSession sqlSession;

	public void generateBlog(Map<String, String> blogMap) {
		System.out.println("BlogDao.generateBlog 블로그생성");

		sqlSession.insert("blog.generateBlog", blogMap);
	}

	public String blogInfo (String id) {
		System.out.println("BlogDao.blogInfo ");
		return sqlSession.selectOne("blog.blogInfo", id);
	}
	
	public void blogDefalut(BlogVo blogVo) {
		System.out.println("BlogDao.blogDefalut 블로그기본값");
		sqlSession.update("blog.blogDefalut", blogVo);
	}
	
	
} // The end of BlogDao

