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
        PrintWriter out = response.getWriter();
        
        DevDTO device = new DevDTO();
        device.setDevice_id(deviceId);
        device.setManufacture(manufacture);
        System.out.println(device);
        
        IoTService service=new IoTService();
        int result = service.devDelete(device);

        if (result > 0) {
            // 삭제 성공 시
            response.sendRedirect("devDelete.do");
            out.println("<script>alert('삭제성공!');</script>");
        } else {
            // 삭제 실패 시
            out.println("<script>alert('삭제에 실패하였습니다.');</script>");
            response.sendRedirect("devDelete.do");
        }
	}
}