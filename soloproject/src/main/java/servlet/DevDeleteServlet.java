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

@WebServlet("/jsp/devDelete.do")

public class DevDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher rd = request.getRequestDispatcher("/jsp/devDelete.jsp");
	      rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String deviceId = request.getParameter("deviceId");
        String manufacture = request.getParameter("manufacture");
        
        DevDTO device = new DevDTO();
        device.setDevice_id(deviceId);
        device.setManufacture(manufacture);
        System.out.println(device);
        
        IoTService service=new IoTService();
        int result = service.devDelete(device);
        System.out.println(result);
        response.sendRedirect("devDelete.do");
	}
}