package frontpattern;

import java.util.Map;

public class EmpListController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> dataMap) {
		String paage = "empList.jsp";
		String method = (String)dataMap.get("method");
		if(method.equals("get")){
			
		}
		return null;
	}

}
