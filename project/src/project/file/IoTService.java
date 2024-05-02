package project.file;

import java.sql.Date;
import java.util.List;
import java.util.Map;



//controller -> service -> DAO
//			<-			<-
//service : 비즈니스로직을 수행한다.
public class IoTService {

	LoginDAO loginDAO = new LoginDAO();
	ControlDAO controlDAO = new ControlDAO();
	
//	public double callFunction(int empid){
//		return empDAO.callFunction(empid);
//	}
//	// 8.삭제(Delete)
//	public int empDelete(int empid) {
//		return empDAO.empDelete(empid);
//	}
//	// 7.수정(Update)
//			public int empUpdate(EmpDTO emp) {
//				return empDAO.empUpdate(emp);
//			}
//	
//	// 6.입력(insert)
//		public int empInsert(EmpDTO emp) {
//		return empDAO.empInsert(emp);
//		}
//	
//
//    //5.다양한 조건으로 조회하기
//    //부서별(=), 직책별(=), 입사일별(>=), 급여(>=)
//    public List<EmpDTO> selectByCondition(int deptid, String jobid, Date hdate, int salary) {
//    	return empDAO.selectByCondition(deptid,jobid, hdate, salary);
//    }
//	
//	//.특정JOB직원 조회
//	public List<EmpDTO> selectByJob(String jobid) {
//		return empDAO.selectByJob(jobid);
//	}
//	
//	//3.특정부서직원
//			public List<EmpDTO> selectBydept(int deptid) {
//				return empDAO.selectBydept(deptid);
//			}
//	
//	//2.특정직원 상세보기
//		public EmpDTO selectById(int empid) {
//			return empDAO.selectById(empid);
//		}
	
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
