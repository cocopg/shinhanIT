package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.DevDTO;
import login.IoTService;


@WebServlet("/jsp/deviceList.do")
public class DeviceListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IoTService service=new IoTService();
		List<DevDTO> devAll = service.selectAll();
		System.out.println(devAll);
		request.setAttribute("devicelist", devAll);
		//Dispatcher: 위임. 요청은 서블릿이 받았는데 응답은 JSP가 한다.
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/deviceList.jsp");
		rd.forward(request, response);
		//response가 전달되었다는 것은 서블릿 대신 JSP가 응답한다의 의미
	}
}