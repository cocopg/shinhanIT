package frontpattern;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.dto.BoardDTO;
import com.shinhan.emp.EmpDTO;

/**
 * Servlet implementation class FrontControllerServlet
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqAddress = request.getRequestURI();
		String path = getServletContext().getContextPath();
		int pathLength = path.length();
		reqAddress = reqAddress.substring(pathLength);
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("method", request.getMethod().toLowerCase());
		CommonControllerInterface controller = null;
		HttpSession session = request.getSession();
		String method = request.getMethod().toLowerCase();
		switch(reqAddress) {
		case "/board/boardDetail.do" ->{
			controller = new BoardDetailController();
			if(method.equals("get")) {
				dataMap.put("bno", Integer.parseInt(request.getParameter("bno")));
			}else {
				int bno = Integer.parseInt(request.getParameter("bno"));
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				String pic = request.getParameter("pic");
				
				BoardDTO board = new BoardDTO(bno, title, content, null, pic, null);
				
				dataMap.put("board", board);
			}
		}
		case "/board/selectAll.do" ->{
			controller = new BoardListController();
		}
		case "/board/boardDelete.do" ->{
			dataMap.put("bno", Integer.parseInt(reqAddress));
			controller = new BoardDeleteController();
		}
		case "/board/boardInsert.do" ->{
			if(method.equals("post")) {
				EmpDTO loginEmp = (EmpDTO) session.getAttribute("loginEmp");
				dataMap.put("request", request);
				dataMap.put("loginEmp",loginEmp);
				
			}
			controller = new BoardInsertController();
		}
		case "/auth/login.do" ->{
			if(method.equals("post")) {
				dataMap.put("email", request.getParameter("email"));
				dataMap.put("pswd", request.getParameter("pswd"));
				//dataMap.put("login");
			}
			controller = new LoginController();
		}
		default -> {}
		}
		String page = controller.execute(dataMap);
		
		for(String key : dataMap.keySet()) {
			request.setAttribute(key, dataMap.get(key));
		}
		
		if(reqAddress.equals("/auth/login.do")&& method.equals("post")) {
			
			//로그인에 성공한건지 실패한건지?
			session.setAttribute("loginEmp", dataMap.get("loginEmp"));
		}
		
		if(page.startsWith("redirect:")) {
			//재요청(주소창이 바뀐다)
			String page2 = page.substring(9);
			String lastRequest = (String)session.getAttribute("lastRequest");
			//redirect:으로 오면 재요청한다.
			//login하지 않고 다른 요청을 했을 때 요청주소는 lastRequest에 저장하고 
			
			if(lastRequest == null || lastRequest.equals("")) {
				response.sendRedirect(path);
			} else {
				response.sendRedirect(page.substring(9));
			}	
		}else {
			//요청을 위임하기 (주소바뀌지 않는다)
			//서블릿은 default주소 /webshop20
			request.getRequestDispatcher(page).forward(request, response);
		}
	}

}
