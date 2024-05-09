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

@WebServlet("/jsp/status.do")
public class StatusUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	RequestDispatcher rd;
        rd = request.getRequestDispatcher("status.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();

        request.setCharacterEncoding("utf-8");
        String device_id = request.getParameter("device_id");
        String status = request.getParameter("status");
        System.out.println(device_id + ":" + status);
        ControlDAO controlDAO = new ControlDAO();
        DevDTO device = new DevDTO();
        device.setDevice_id(device_id);
        device.setStatus(status);

        int result = controlDAO.devUpdate(device);
        

        
    }
}
