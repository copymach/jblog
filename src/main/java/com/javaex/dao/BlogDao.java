package com.javaex.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BlogDao {

	@Autowired
	private SqlSession sqlSession;

	public void generateBlog(Map<String, String> blogMap) {
		System.out.println("BlogDao.generateBlog 블로그생성");

		sqlSession.insert("blog.generateBlog", blogMap);
	}

	public String blogMain (String id) {
		System.out.println("BlogDao.blogMain ");
		return sqlSession.selectOne("blog.blogMain", id);
	}

} // The end of BlogDao
