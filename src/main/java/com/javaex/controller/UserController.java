package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/joinForm", method= {RequestMethod.POST, RequestMethod.GET})
	public String joinForm() {
		System.out.println("UserController.joinForm ");
		return "/user/joinForm";
	} 
	
	@RequestMapping(value="/join")
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("UserController.join 실행");
		userService.join(userVo);
		return "/user/joinSuccess";
	}
	
	@RequestMapping(value="/loginForm")
	public String loginForm() {
		System.out.println("UserController.loginForm ");
		return "/user/loginForm";
	} 
	
	@RequestMapping(value="/login")
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController.login ");
		UserVo authUser = userService.login(userVo); 
		System.out.println(authUser);
		
		if (authUser != null) {
			System.out.println("로그인 성공");
//			세션에 저장
			session.setAttribute("authUser", authUser);
//			메인으로 리다이렉트
			return "redirect:/";
			
		} else { // 로그인 실패
			System.out.println("로그인 실패");
			return "redirect:/user/loginForm?result=fail";
		}
	}

	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		System.out.println("UserController.logout ");
		session.removeAttribute("authUser"); // 세션정보삭제
		session.invalidate(); // 세션 초기화
		System.out.println("UserController 로그아웃성공 세션비움 성공");
		return "redirect:/";
	}

	
	
	
} // The end of UserController 
