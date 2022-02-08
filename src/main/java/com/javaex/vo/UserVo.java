package com.javaex.vo;

public class UserVo {

//	필드
	private int userNo; // 회원식별번호 pk
	private String id; // 아이디 낫널 유니크
    private String userName; // 이름
    private String password; // 비번
    private String joinDate; // 가입일
    
//  컨스트럭터
	public UserVo() {
	}
	public UserVo(int userNo, String id, String userName, String password, String joinDate) {
		this.userNo = userNo;
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.joinDate = joinDate;
	}
	
//	메서드 gs
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	
//	메서드 일반
	@Override
	public String toString() {
		return "UserVo [userNo=" + userNo + ", id=" + id + ", userName=" + userName + ", password=" + password
				+ ", joinDate=" + joinDate + "]";
	}
    
} // The end of UserVo
