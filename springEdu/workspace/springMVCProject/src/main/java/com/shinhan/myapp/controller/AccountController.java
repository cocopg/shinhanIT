package com.shinhan.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccountController {
	
	@Autowired
	AccountServiceImpl accService;
	
	@RequestMapping("/account/trans.do")
	@ResponseBody //응답의 문자는 response.getWriter().
	
	public String f1() {
		accService.update();
		return "Account transaction test";
	}
}
