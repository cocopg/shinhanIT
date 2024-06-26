package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.IoTService;
import login.LogDTO;
import login.ResDTO;


@WebServlet("/jsp/resList.do")
public class ResListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IoTService service=new IoTService();
		List<ResDTO> reslist = service.resList();
		System.out.println(reslist);
		request.setAttribute("reslist", reslist);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/resList.jsp");
		rd.forward(request, response);
	}
}