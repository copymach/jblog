package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository 
public class UserDao {

	@Autowired
	private SqlSession sqlSession;
	
//	회원가입용 유저정보입력
	public void insertUser(UserVo userVo) {
		System.out.println("UserDao.insertUser 실행"+userVo);
		sqlSession.insert("user.insertUser", userVo);
	}
	
	public void insertNewBlog(UserVo userVo) {
		System.out.println("UserDao.insertUser 실행"+userVo);
		sqlSession.insert("blog.insertNewBlog", userVo);
	}
	
	
//	로그인용 유저정보
	public UserVo selectUser(UserVo userVo) {
		System.out.println("UserDao.selectUser 실행"+userVo);
		
		UserVo authUser = sqlSession.selectOne("user.selectUser", userVo);
		
		return authUser;
	}
	
	
} // The end of UserDao
