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
import javax.servlet.http.HttpSession;

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
        response.setCharacterEncoding("utf-8");
        
        String deviceId = request.getParameter("deviceId");
        String manufacture = request.getParameter("manufacture");
        String dType = request.getParameter("d_type");
        String status = request.getParameter("status");
        String roomName = request.getParameter("room_name");
        
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("user_id");
        System.out.println(userId);
        
        DevDTO device = new DevDTO();
        device.setDevice_id(deviceId);
        device.setManufacture(manufacture);
        device.setD_type(dType);
        device.setStatus(status);
        device.setRoom_name(roomName);
        device.setUser_id(userId);
        
        DevDTO dev = new DevDTO(deviceId,manufacture,dType,null, status,roomName,userId, userId);
        
        IoTService service = new IoTService();
		int result = service.devInsert(dev);
		response.setContentType("text/plain");
	    PrintWriter out = response.getWriter();
	    out.print(result);
        
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/devInsert.jsp");
        rd.forward(request, response);
    }
}
