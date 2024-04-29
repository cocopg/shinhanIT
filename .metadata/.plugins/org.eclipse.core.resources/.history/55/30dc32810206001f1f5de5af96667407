package com.shinhan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Enumeration;
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
import com.shinhan.util.DBUtil;
import com.shinhan.util.DateUtil;

/**
 * Servlet implementation class EmpInsertServlet
 */
@WebServlet("/emp/empInsert.do")
public class EmpInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		
   		DeptService service = new DeptService();
   		List<DeptDTO> dlist = service.selectAll();
   		request.setAttribute("deptlist", dlist);
   		
   		EmpService eService = new EmpService();
   		List<HashMap<String, Object>> mlist = eService.selectAllMng();
   		request.setAttribute("mlist", mlist);
   		
   		EmpService jService = new EmpService();
   		List<EmpDTO> jlist = jService.selectAll();
   		request.setAttribute("jlist", jlist);
   		
   		RequestDispatcher rd = 
   				request.getRequestDispatcher("empInsert.jsp");
   	    rd.forward(request, response);
   	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청문서에 내용을 담아서 온다. 자동 encoding안됨 
		request.setCharacterEncoding("utf-8");//1문자가 3byte임을 설정 
		EmpDTO emp = makeEmp(request);
		EmpService service = new EmpService();
		int result = service.empInsert(emp);
		System.out.println(result + "건 입력됨");
		request.setAttribute("message", result + "건 입력됨");

		//jsp에 응답을 위임하는 경우(mvc2모델)
		RequestDispatcher rd = 
   				request.getRequestDispatcher("result.jsp");
   	    rd.forward(request, response);
		
//		//servlet이 직접 응답하는경우
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.write("<h1>서블릿이 직접 응답하는경우</h1>");
	}
	private EmpDTO makeEmp(HttpServletRequest request) {
		
		//Enumeration : 한정된 값의 나열을 의미
		Enumeration<String> colnames = request.getParameterNames();
		while(colnames.hasMoreElements()) {
			String col=colnames.nextElement();
			System.out.println(col+"==>"+request.getParameter(col));
		}
		
		EmpDTO emp = new EmpDTO();
		int empid = convertInt(request.getParameter("employee_id"));
		int mid = convertInt(request.getParameter("manager_id"));
		int did = convertInt(request.getParameter("department_id"));
		int salary = convertInt(request.getParameter("salary"));
		double commission = convertDouble(request.getParameter("commission_pct"));
		String fname = request.getParameter("first_name");
		String lname = request.getParameter("last_name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone_number");
		String job_id = request.getParameter("job_id");
		Date hdate = DateUtil.getSQLDate(request.getParameter("hire_date"));
		
		emp.setCommission_pct(commission);
		emp.setDepartment_id(did);
		emp.setEmail(email);
		emp.setEmployee_id(empid);
		emp.setFirst_name(fname);
		emp.setHire_date(hdate);
		emp.setJob_id(job_id);
		emp.setLast_name(lname);
		emp.setManager_id(mid);
		emp.setPhone_number(phone);
		emp.setSalary(salary);
		System.out.println(emp);
		return emp;
	}
	private double convertDouble(String parameter) {
		if(parameter==null) return 0;
		return Double.parseDouble(parameter);
	}
	private int convertInt(String parameter) {
		if(parameter==null) return 0;
		return Integer.parseInt(parameter);
	}
	

}