package org.firstzone.myapp.emp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.shinhan.myapp.util.DBUtil;

@Repository("empmybatis")
// DAO(Data Access하는 비즈니스 로직을 처리하는 Object)
public class EmpDAOMybatis{

	@Autowired
	SqlSession sqlSession;
	String namespace = "com.shinhan.emp.";

	Logger logger = LoggerFactory.getLogger(EmpDAOMybatis.class);

	public List<EmpDTO> selectAll() {
		List<EmpDTO> emplist = sqlSession.selectList(namespace + "selectAll");
		logger.info(emplist.size() + "건 조회됨");
		return emplist;
	}

	public EmpDTO loginCheck(String email, String phone) {
		System.out.println(email);
		EmpDTO emp = sqlSession.selectOne(namespace + "loginCheck", email);
		logger.info(emp.toString());
		return emp;
	}

	public int empDelete(int empid) {
		int result = sqlSession.delete(namespace + "empDelete", empid);
		logger.info(result + "건 삭제됨");
		return result;
	}

	public int empUpdate(EmpDTO emp) {
		int result = sqlSession.update(namespace + "empUpdate", emp);
		logger.info(result + "건 update됨");
		return result;
	}

	public int empInsert(EmpDTO emp) {
		int result = sqlSession.insert(namespace + "empInsert", emp);
		logger.info(result + "건 추기됨");
		return result;
	}

	public List<EmpDTO> selectByCondition(int deptid, String jobid, Date hdate, int salary) {
		Map<String, Object> conditionMap = new HashMap<>();
		conditionMap.put("deptid", deptid);
		conditionMap.put("jobid", jobid);
		conditionMap.put("hdate", hdate);
		conditionMap.put("salary", salary);
		List<EmpDTO> emplist = sqlSession.selectList(namespace + "selectByCondition", conditionMap);
		logger.info(emplist.size() + "건 조건 조회됨");
		return emplist;
	}

	public List<EmpDTO> selectByJob(String job) {
		List<EmpDTO> emplist = sqlSession.selectList(namespace + "selectByJob", job);
		logger.info(emplist.size() + "건 조건 조회됨");
		return emplist;
	}

	public List<EmpDTO> selectByDept(int dept) {
		List<EmpDTO> emplist = sqlSession.selectList(namespace + "selectByDept", dept);
		logger.info(emplist.size() + "건 조건 조회됨");
		return emplist;
	}

	public EmpDTO selectById(int empid) {
		EmpDTO emp = sqlSession.selectOne(namespace + "selectById", empid);
		
		return emp;
	}

	public int selectByEmail(String email) {
		Integer result = sqlSession.selectOne(namespace + "selectByEmail", email);
		logger.info(result.toString());
		return result;
	}

	public List<JobDTO> selectAllJob() {
		List<JobDTO> joblist = sqlSession.selectList(namespace + "selectAllJob");
		logger.info(joblist.size() + "건 직무 조회됨");
		return joblist;
	}
	
	public List<HashMap<String, Object>> selectAllManager() {
		List<HashMap<String, Object>> mlist = sqlSession.selectList(namespace + "selectAllManager");
		logger.info(mlist.size() + "건 매니저 조회됨");
		return mlist;
	}

	public Map<String, Object> empInfo(int empid) {

		return null;
	}

	// 10. 직원 번호가 들어오면 직원 보너스를 return 하는 함수를 호출
	public double callFunction(int empid) {

		return 0;
	}

	

}
