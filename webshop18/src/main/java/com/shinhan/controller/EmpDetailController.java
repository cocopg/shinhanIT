package com.shinhan.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dept.DeptDTO;
import com.shinhan.dept.DeptService;
import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;

/**
 * http://ip:post/path/emp/empDetail
 */
@WebServlet("/emp/empDetail.do")
public class EmpDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmpDetailController() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 에러 종류
	// 404: page가 존재하지 않는다. 주소 확인하기
	// 405: 요청 방식을 지원하지 않는다. get인지 post인지 확인하기
	// 500: 서버 오류. 프로그램 실행 오류이므로 서버의 console창 확인
	// 200: 성공

	// doGet(), doPost() 코드가 같다면 service() 메서드에서 코드한다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("==============get 요청==============");

		EmpService eService = new EmpService();
		String empid = request.getParameter("empid");
		System.out.println("empid : " + empid);
		if (empid == null)
			return;

		int i_empid = Integer.parseInt(empid);
		EmpDTO emp = eService.selectById(i_empid);
		System.out.println(emp);

		// 요청 문서에 data를 저장한다.
		request.setAttribute("empInfo", emp);

		// 모든 부서
		// 모든 job
		// 모든 매니저
		DeptService service = new DeptService();
		List<DeptDTO> dlist = service.selectAll();
		// System.out.println(dlist.size()+"건");
		request.setAttribute("deptlist", dlist);

		List<HashMap<String, Object>> mlist = eService.selectAllManager();
		request.setAttribute("mlist", mlist);

		List<String> jlist = eService.selectAllJob();
		request.setAttribute("jlist", jlist);

		// Java code는 Servlet 담당......비즈니스 로직을 수행 후
		// View(HTML)는 JSP 담당......JSP에 넘긴다.

		// Browser가 요청 -> 서블릿이 받음 -> JSP에게 위임함
		RequestDispatcher rd = request.getRequestDispatcher("empDetail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}