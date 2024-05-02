package com.shinhan.emp;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Controller -> Service -> DAO
//           <-         <-
//Service: 비즈니스 로직을 수행한다.
public class EmpService {

	EmpDAO empDAO = new EmpDAO();

	// 이메일 중복체크
	public int selectByEmail(String email) {
		return empDAO.selectByEmail(email);
	}

	// 1. 직원 모두 조회
	public List<EmpDTO> selectAll() {
		return empDAO.selectAll();
	}

	// 2. 특정 직원 상세 보기
	public EmpDTO selectById(int empid) {
		return empDAO.selectById(empid);
	}

	// 3. 특정 부서에 근무하는 직원들
	public List<EmpDTO> selectByDpt(int dptId) {
		return empDAO.selectByDpt(dptId);
	}

	// 4. 특정 JOB인 직원들
	public List<EmpDTO> selectByJob(String jobId) {
		return empDAO.selectByJob(jobId);
	}

	// 5. 다양한 조건으로 조회하기
	// 부서별(=), 직책별(=), 입사일별(>=), 급여((>=)
	public List<EmpDTO> selectByCondition(int deptid, String jobid, Date hdate, int salary) {
		return empDAO.selectByCondition(deptid, jobid, hdate, salary);
	}

	// 6. 입력(Insert)
	public int empInsert(EmpDTO emp) {
		return empDAO.empInsert(emp);
	}

	// 7. 수정(Update)
	public int empUpdate(EmpDTO emp) {
		return empDAO.empUpdate(emp);
	}

	// 8. 삭제(Delete)
	public int empDelete(int empid) {
		return empDAO.empDelete(empid);
	}

	// 직원번호를 이용해서 직원의 이름과 직책과 급여를 조회한다.
	public Map<String, Object> empInfo(int empid) {
		return empDAO.empInfo(empid);
	}

	// 직원 번호가 들어오면 직원 보너스를 return하는 함수를 호출한다.
	public double callFunction(int empid) {
		return empDAO.callFunction(empid);
	}

	// 매니저 모두 조회
	public List<HashMap<String, Object>> selectAllManager() {
		return empDAO.selectAllManager();
	}

	// 직업 모두 조회
	public List<String> selectAllJob() {
		return empDAO.selectAllJob();
	}
}