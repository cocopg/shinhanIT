package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

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

@WebServlet("/jsp/devInsert.do")
public class DevInsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	RequestDispatcher rd;
        rd = request.getRequestDispatcher("/jsp/devInsert.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	//여기하고
		String deviceid=request.getParameter("device_id");
		String manufacture=request.getParameter("manufacture");
		String d_type=request.getParameter("d_type");
		String status=request.getParameter("status");
		String room_name=request.getParameter("room_name");
		
		ResDTO res = new ResDTO();
		
		IoTService service=new IoTService();
		int result = service.resInsert(res);
		
		request.setAttribute("message", result+"건 입력됨");
		RequestDispatcher rd;
		rd=request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);

        
    }
}
