package controller5;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/jsp/order.go")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("order.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String menuName = request.getParameter("lunch");
		int count = Integer.parseInt(request.getParameter("count"));
		System.out.println(menuName + "==>" + count);
		
		//request? 요청시마다 값이 다르다.X
		//session? 브라우저당 하나 O
		//application? 다른 사람과 공유 X
		
		HttpSession session = request.getSession();
		Map<String, Integer>cart = (Map<String,Integer>) session.getAttribute("cart");
		if(cart==null) {
			cart = new HashMap<String, Integer>();
			cart.put(menuName, count);
		}else {
			if(cart.containsKey(menuName)) {//이미 주문한 메뉴면
				cart.put(menuName, cart.get(menuName) + count); //카운트추가
			}else {
				cart.put(menuName,count); //아니면 새로추가
			}
		}
		session.setAttribute("cart", cart);
		
		request.getRequestDispatcher("orderResult.jsp").forward(request, response);
//		response.sendRedirect("order.go");
		
	}

}
