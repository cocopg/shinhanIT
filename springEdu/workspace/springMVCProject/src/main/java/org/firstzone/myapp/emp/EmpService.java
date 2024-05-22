package org.firstzone.myapp.emp;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


// Controller -> Service -> DAO
// Service
@Service
public class EmpService {

	//???��?�� 같으�? ?��?��?���? injection
	@Autowired
	@Qualifier("empmybatis")
	EmpDAOMybatis empDAO;

	public EmpDTO loginCheck(String email, String phone) {
		return empDAO.loginCheck(email, phone);
	}
	// 1. 吏곸?�� 紐⑤�? 議고?��
	public List<EmpDTO> selectAll() {
		return empDAO.selectAll();
	}

	// 2. �듅�젙 吏곸?�� 1紐� 議고?�� - �긽�꽭蹂닿�?
	public EmpDTO selectByID(int empID) {
		return empDAO.selectById(empID);
	}
	
	// 3. �듅�젙 ?����꽌�?�� 吏곸?���뱾 議고?��
	public List<EmpDTO> selectByDeptID(int departmentID) {
		return empDAO.selectByDept(departmentID);
	}
	
	// 4. �듅�젙 job�씤 吏곸?��議고?��
	public List<EmpDTO> selectByJob(String jobID) {
		return empDAO.selectByJob(jobID);
	}
	
	// 5. �떎�뼇�븳 議곌굔�?��濡� 議고?���븯湲�
	// ?����꽌蹂�?(=), 吏곸콉蹂�?(=), �엯�궗�씪蹂�(>=), 湲됱�?(>=)	
	public List<EmpDTO> selectByCondition(int deptid, String jibid, Date hdate, int salary) {
		return empDAO.selectByCondition(deptid, jibid, hdate, salary);
	}
	
	// 6. �엯�젰
	public int empInsert(EmpDTO emp) {
		return empDAO.empInsert(emp);
	}
	
	// 7. �닔�젙
	public int empUpdate(EmpDTO emp) {
		return empDAO.empUpdate(emp);
	}
	// 8. �궘�젣
	public int empDelete(int empid) {
		return empDAO.empDelete(empid);
	}

	// 9. 吏곸?�� 踰덊?��?���? �씠�슜�빐�꽌 吏곸?���쓽 �씠?��꾧낵 吏곸콉�?�� 湲됱뿬瑜�? 議고?���븳�떎.
	public Map<String, Object> empInfo(int empid) {
		return empDAO.empInfo(empid);
	}
	
	// 10. 吏곸?��踰덊?��媛� �뱾�뼱�삤硫� 吏곸?�� 蹂�?꼫�?��?���? return�븯�뒗 �븿�닔?���? �샇?��?��븳�?��.
		public double callFunction(int empid) {
			return empDAO.callFunction(empid);
		}
		public List<HashMap<String, Object>> selectAllManager() {
			return empDAO.selectAllManager();
		}
		public List<JobDTO> selectAllJob() {
			return empDAO.selectAllJob();
		}
}