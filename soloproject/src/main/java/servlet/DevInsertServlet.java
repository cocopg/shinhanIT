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
        request.setCharacterEncoding("utf-8");
        
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
        
        ControlDAO dao = new ControlDAO();
        int result = dao.devInsert(device);
        
        String message = (result > 0) ? "기기가 추가되었습니다." : "기기 추가에 실패했습니다.";
        request.setAttribute("message", message);
        
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/devInsert.jsp");
        rd.forward(request, response);
    }
}
