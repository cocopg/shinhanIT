package com.shinhan.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//요청주소연습


@Controller
//공통적인 path는 클래스 레벨에서 정의, 각각은 메서드 레벨에 작성
@RequestMapping("/sample")
public class SampleController {
	
	@RequestMapping("hello.do")
	public String test1() {
		return "jsp/hello";
	}
	
	@RequestMapping("/hello1.do")
	public String test2() {
		return "jsp/hello";
	}
	
	@RequestMapping(value = {"/hello2.do", "/hello3.do"},
					method=RequestMethod.GET)
	public String test3() {
		return "jsp/hello";
	}
	
	@GetMapping("/hello4.do")
	public String test4(Model data) {
		data.addAttribute("myname","신한DS");
		data.addAttribute("myscore",100);
		return "jsp/hello";
	}
	
	@GetMapping("/hello5.do")
	public ModelAndView test5() {
		//ModelAndView data = new ModelAndView("jsp/hello");
		ModelAndView data = new ModelAndView();
		data.setViewName("jsp/hello");
		data.addObject("myname","신한DS...");
		data.addObject("myscore",99);
		return data;
	}
	
	@RequestMapping(value="/hello6.do", method = RequestMethod.GET,
			params = {"email", "pw=1234", "!adress"})
	public String test6(Model model, @RequestParam("email") String email2, String pw, String phone) {
		System.out.println("====/hello6.do요청====");
		System.out.println(email2);
		System.out.println(pw);
		System.out.println(phone);
		model.addAttribute("lunch","점메추?삼겹살");
		return "jsp/hello6"; //forward(request, response)
	}
	//@RequestMapping(value="/hello6.do", method = RequestMethod.POST)
	@PostMapping("/hello6.do")
	public void test7(
			@RequestParam("email")String email,
			@RequestParam(value="pw", required = false)String pw,
			String phone) {
		System.out.println(email);
		System.out.println(pw);
		System.out.println(phone);
	}
}
