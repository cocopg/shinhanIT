package project.file;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.shinhan.emp.EmpDTO;



//controller -> service -> DAO
//			<-			<-
//service : 비즈니스로직을 수행한다.
public class IoTService {
	
	LoginDAO logindao = new LoginDAO();
	
	public UserDTO loginCheck(String email, String phone) {
		return logindao.loginCheck(email, phone);
	}

	LoginDAO loginDAO = new LoginDAO();
	ControlDAO controlDAO = new ControlDAO();
	
	//특정기기 활동로그
	
	public List<LogDTO> deviceLog(LogDTO device) {
		return controlDAO.deviceLog(device);
	}
	//활동로그 전체출력
	public List<LogDTO> logAll() {
		return controlDAO.logAll();
	}
	
	//기기삭제
	public int devDelete(DevDTO device) {
		return controlDAO.devDelete(device);
	}
	
	//기기추가
	public int devInsert(DevDTO device) {
		return controlDAO.devInsert(device);
	}
	//예약전체보기
	public List<ResDTO> resList() {
	    return controlDAO.resList();
	}
	//예약삭제
	public int resDelete(int reservationId) {
		return controlDAO.resDelete(reservationId);
	}
	
	//3.시간예약
	public int resInsert(ResDTO res) {
		return controlDAO.resInsert(res);
	}
	
	//2.디바이스 on/off 수정
	public int devUpdate(DevDTO device) {
		return controlDAO.devUpdate(device);
	}
	
	//1.모든 디바이스 조회
	public List<DevDTO> selectAll() {
			return controlDAO.selectAll();
		}
	
	
//	//직원번호 이용해서 이름과 직책, 급여를 조회한다.
//	public Map<String, Object> empInfo(int empid) {
//		// TODO Auto-generated method stub
//		return empDAO.empInfo(empid);
//	}
}
