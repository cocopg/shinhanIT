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
import login.ResDTO;

@WebServlet("/jsp/res.do")
public class ResServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	RequestDispatcher rd;
        rd = request.getRequestDispatcher("/jsp/res.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	
		String deviceid = request.getParameter("device_id");
		String start = request.getParameter("start_time");
		String end = request.getParameter("end_time");
		
		ResDTO res = new ResDTO(deviceid,start,end);
		
		IoTService service=new IoTService();
		int result = service.resInsert(res);
		
		 response.setContentType("text/plain");
		    PrintWriter out = response.getWriter();
		    out.print(result);
		
    }
    
}
