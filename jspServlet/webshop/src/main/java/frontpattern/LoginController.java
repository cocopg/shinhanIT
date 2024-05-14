package frontpattern;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;

public class LoginController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> dataMap) {
		String page = "login.jsp";
		String method = (String)dataMap.get("method");
		if(method.equals("get")) return page;
		
		EmpService empService = new EmpService();
		String email = (String)dataMap.get("email");
		String phone = (String)dataMap.get("pswd");
		EmpDTO emp = empService.loginCheck(email, phone);
		if (emp == null || emp.getEmployee_id() == -1) {
			// 존재하지 않는 직원
			dataMap.put("message", "존재하지 않는 직원");
		} else if (emp.getEmployee_id() == -2) {
			// 비밀번호 오류
			dataMap.put("message", "비밀번호오류");
		} else {
			// 로그인 성공
			dataMap.put("loginEmp", emp);
			HttpSession session = (HttpSession)dataMap.get("session");
			String lastRequest = (String)session.getAttribute("lastRequest");
			if(lastRequest == null || lastRequest.equals("")) {
				return "redirect:";
			}
			return "redirect:" + lastRequest;
		}
		//로그인에 실패하면 결과페이지 보여주기
			
		return "result.jsp";
	}

}
