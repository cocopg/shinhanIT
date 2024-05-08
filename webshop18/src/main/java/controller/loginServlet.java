package controller4;

import java.io.IOException;
import java.time.temporal.UnsupportedTemporalTypeException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;



@WebServlet("/auth/login.do")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// login 창 보여주기
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 사용자가 입력한 ID, PW 검사
		EmpService empService = new EmpService();
		String email = request.getParameter("email");
		String phone = request.getParameter("pswd");
		EmpDTO emp = empService.loginCheck(email, phone);
		if (emp == null || emp.getEmployee_id() == -1) {
			// 존재하지 않는 직원
			request.setAttribute("message", "존재하지 않는 직원");
		} else if (emp.getEmployee_id() == -2) {
			// 비밀번호 오류
			request.setAttribute("message", "비밀번호오류");
		} else {
			// 로그인 성공
			HttpSession session = request.getSession();
//			LoginImpl loginUser = new LoginImpl(email, phone);
//					
//			if(session.isNew()) {
//				session.setAttribute("loginUser", loginUser);
//			}
			
			session.setAttribute("loginEmp", emp);
			
			response.sendRedirect("../emp/empList.do");
			return;
		}
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}

}
