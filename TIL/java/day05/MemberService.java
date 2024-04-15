package com.shinhan.day05;

public class MemberService {
	boolean login(String id, String password) {
		if(id.equals("admin") && password.equals("12345")) {
			return true;
		}
		return false;
	}
	boolean login2(String id, String password) {
		return id.equals("hong") && password.equals("12345");
	}
	void logout (String id) {
		System.out.println(id+"님이 로그아웃 하셨습니다.");
	}

}
