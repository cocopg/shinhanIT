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
		if (residStr != null && !residStr.isEmpty()) {
			int resid = Integer.parseInt(residStr);

			IoTService service = new IoTService();
			int result = service.resDelete(resid);

		}
		RequestDispatcher rd;
		rd=request.getRequestDispatcher("/jsp/resCancel.jsp");
		rd.forward(request, response);

	}
}
