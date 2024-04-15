package com.shinhan.day05;

public class MemberApp {

	public static void main(String[] args) {
		MemberService memberService = new MemberService();
		boolean result = memberService.login("hong2", "12345");
				if (result) {
					System.out.println("로그인 되었습니다.");
					memberService.logout("hong");
				}else {
					System.out.println("id또는 password가 올바르지 않습니다.");
				}
		
	}

}
