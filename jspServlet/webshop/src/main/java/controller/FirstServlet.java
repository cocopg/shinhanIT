package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 * 
 * @webServlet : 주소창에서 요청시 mapping주소
 */
@WebServlet({ "/FirstServlet", "/first1", "/first2" })//web.xml과 중복된 이름이 없도록 주의
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FirstServlet() {
		super();
		System.out.println("FirstServlet생성자");
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("FirstServlet init(초기화)");
	}

	public void distroy() {
		System.out.println("FirstServlet 소멸자");
		// doGet, doPost()코드를 모두 해야하는 경우
	}

//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("================service================");
//		System.out.println(req.getMethod() + "요청");
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String addr = request.getRemoteAddr();
		System.out.println("FirstServlet get요청:" + addr);
		System.out.println("userid:" + request.getParameter("userid"));
		response.getWriter().append("<h1>Served at(get): ")
//		.append(addr)
		.append(request.getContextPath() + "<h1>")
		.append("<script></script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String addr = request.getRemoteAddr();
		System.out.println("FirstServlet post요청" + addr);
		System.out.println("userid: " + request.getParameter("userid"));
		doGet(request, response);
	}

}
