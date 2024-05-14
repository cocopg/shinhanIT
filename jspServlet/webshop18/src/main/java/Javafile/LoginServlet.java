package auth;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/auth/login.do")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IoTService iotService = new IoTService();
    	String userId = request.getParameter("user_id");
        String password = request.getParameter("password");
        
        LoginDAO loginDAO = new LoginDAO();
        String loggedInUserId = loginDAO.login(userId, password);
        
        if (loggedInUserId != null) {
            // 로그인 성공
            response.getWriter().write("success");
        } else {
            // 로그인 실패
            response.getWriter().write("failure");
        }
        RequestDispatcher rd;
		rd = request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
    }
}