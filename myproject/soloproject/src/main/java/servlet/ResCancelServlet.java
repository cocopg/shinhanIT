package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.ControlDAO;
import login.DevDTO;
import login.IoTService;

@WebServlet("/jsp/resCancel.do")

public class ResCancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String residStr = request.getParameter("resid");
		int result = 0;
		if (residStr != null && !residStr.isEmpty()) {
			int resId = Integer.parseInt(residStr);

			IoTService service = new IoTService();
			result = service.resDelete(resId);
			
			response.setContentType("text/plain;"); 
			PrintWriter out = response.getWriter();
			out.print(result);

		}
		System.out.println("받는값" + result);
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("/jsp/resCancel.jsp");
			rd.forward(request, response);		
			
			
	}
}