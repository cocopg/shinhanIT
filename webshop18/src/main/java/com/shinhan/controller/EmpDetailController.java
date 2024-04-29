package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;


@WebServlet("/emp/empDetail.do")
public class EmpDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * 404:페이지가 존재하지 않음. 주소확인
	 * 405:요청방식을 지원하지 않음. get/post확인
	 * 500:서버오류, 실행오류이므로 콘솔창 확인
	 * 200:성공
	 * */
	
	//doGet(), doPost()코드가 같다면 service()메서드에서 코드한다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("============get============");

		EmpService empService = new EmpService();
		String empid = request.getParameter("empid");
		if (empid == null)
			return;

		int i_empid = Integer.parseInt(empid);
		EmpDTO emp = empService.selectById(i_empid);
		System.out.println(emp);
		
		// 요청문서에 data 저장
		request.setAttribute("empInfo", emp);
		
		// send to jsp
		RequestDispatcher rd = request.getRequestDispatcher("empDetail.jsp");
		rd.forward(request, response);
	}

}