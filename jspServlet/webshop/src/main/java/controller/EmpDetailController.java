package controller;

import java.io.IOException;
import java.sql.Date;
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
import com.shinhan.util.DateUtil;

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
		EmpDTO emp = eService.selectByID(i_empid);
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
		// 요청문서의 내용을 담아서 온다. 자동 encoding 안됨
//		request.setCharacterEncoding("utf-8");
		//filter로 대체
		
		EmpDTO emp = makeEmp(request);
		EmpService empService = new EmpService();
		String result = String.valueOf(empService.empUpdate(emp)) + "건이 수정됨";
		System.out.println(result);
		request.setAttribute("message", result);

		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);

	}

	private EmpDTO makeEmp(HttpServletRequest request) {
		EmpDTO emp = new EmpDTO();
		int empid = convertInt(request.getParameter("empid"));
		int magid = convertInt(request.getParameter("magid"));
		int deptid = convertInt(request.getParameter("deptid"));
		int salary = convertInt(request.getParameter("salary"));
		double commition = convertDouble(request.getParameter("commition"));
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone_number");
		String jid = request.getParameter("jid");
		Date hdate = DateUtil.getSQLDate(request.getParameter("hdate"));

		emp.setEmployee_id(empid);
		emp.setManager_id(magid);
		emp.setDepartment_id(deptid);
		emp.setSalary(salary);
		emp.setCommission_pct(commition);
		emp.setFirst_name(fname);
		emp.setLast_name(lname);
		emp.setEmail(email);
		emp.setPhone_number(phone);
		emp.setJob_id(jid);
		emp.setHire_date(hdate);
		return emp;
	}

	private double convertDouble(String parameter) {
		if (parameter == null)
			return 0;
		return Double.parseDouble(parameter);
	}

	private int convertInt(String parameter) {
		if (parameter == null)
			return 0;
		return Integer.parseInt(parameter);
	}

}