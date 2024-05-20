package com.shinhan.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.firstzone.myapp.emp.EmpDTO;
import org.firstzone.myapp.emp.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@Autowired
	EmpService eService;
	
	@GetMapping("/auth/login.do")
	public void loginDisplay() {
		
	}
	
	@GetMapping("/auth/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login.do";
	}
	
	@PostMapping("/auth/login.do")
	public String loginCheck(@RequestParam("email") String email,
			@RequestParam("pswd") String phone,
			HttpSession session,
			HttpServletRequest request) {
		
		EmpDTO emp = eService.loginCheck(email, phone);
		if(emp.getEmployee_id() ==-1) {
			session.setAttribute("loginResult", "�������� �ʴ� ID�Դϴ�.");
			return "redirect:login.do";
		}else if(emp.getEmployee_id() ==-2) {
			session.setAttribute("loginResult", "��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			return "redirect:login.do";
		}else {
			//�α��μ���
			session.setAttribute("loginResult", "�α��� ����.");
			session.setAttribute("emp", emp);
			
			String lastRequest = (String)session.getAttribute("lastRequest");
			String goPage;
			if(lastRequest == null) {
				goPage = "../index.do";
			}else {
				//�α��� ���� �ٸ� �������� ��û
				int length = request.getContextPath().length();
				goPage = lastRequest.substring(length);
			}

			return "redirect:" + goPage;
		}
		
	}

}
