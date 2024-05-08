package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.IoTService;

@WebServlet("/jsp/login.do")
public class LoginServlet extends HttpServlet {
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   RequestDispatcher rd;
	         rd = request.getRequestDispatcher("login.jsp");
	         rd.forward(request, response);
	 }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("user_id");
        String password = request.getParameter("password");
        
        IoTService service = new IoTService();
        String loggedInUserId = service.login(userId, password);
        System.out.println(loggedInUserId);
        System.out.println(userId + ":" +  password);
        if (loggedInUserId != null) {
            // 로그인 성공
            response.getWriter().write("success");
        } else {
            // 로그인 실패
            response.getWriter().write("failure");
        }
        
        
      
    }
}
