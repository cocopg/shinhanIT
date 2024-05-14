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
import login.LoginDAO;
import login.ResDTO;

@WebServlet("/jsp/sign.do")
public class SignServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	RequestDispatcher rd;
        rd = request.getRequestDispatcher("/jsp/sign.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");

    	String userId = request.getParameter("userid");
        String password = request.getParameter("password");
        String name = request.getParameter("name");

        LoginDAO loginDAO = new LoginDAO();

        boolean isSuccess = loginDAO.register(userId, password, name);

        if (isSuccess) {
            response.getWriter().write("success");
        } else {
            response.getWriter().write("failure");
        }

    }
}
