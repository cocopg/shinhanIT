package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/second", "/second2"})
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String method = request.getMethod(); //요청방식
		String addr = request.getRemoteAddr(); //요청주소
		String cpath = request.getServletContext().getContextPath();
		String path = request.getServletContext().getRealPath(".");

		//response.getWriter() : 응답문서
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.printf("<h1>응답문서</h1>");
		out.printf("<p>method:%s</p>", method);
		out.printf("<p>addr:%s</p>", addr);
		out.printf("<p>cpath:%s</p>", cpath);
		out.printf("<p>path:%s</p>", path);
		//서블릿:서버에서 실행되는 자바프로그램(Java!!!! + HTML)
		//JSP:서버에서 실행되는 자바프로그램(Java + HTML!!!)
	}
}
