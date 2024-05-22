package org.firstzone.myapp.dept;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.xml.stream.events.Namespace;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shinhan.myapp.util.DBUtil;

@Repository("deptmybatis")
public class DeptDAOMybatis implements DeptDAOInterface {

	@Autowired
	SqlSession sqlSession;

	Logger logger = LoggerFactory.getLogger(DeptDAOMybatis.class);
	String namespace="com.shinhan.dept.";

	public List<DeptDTO> selectAll() {
		System.out.println("======");
		logger.info("DeptDAOMybatis...selectAll()");
		
		return sqlSession.selectList("com.shinhan.dept.selectAll");
	}
	
	public DeptDTO selectById(int deptid) {
		logger.info("DeptDAOMybatis...selectById()");
		return sqlSession.selectOne(namespace + "selectById", deptid);
	}

	public int deptInsert(DeptDTO dept) {
		logger.info("DeptDAOMybatis...deptInsert()");
		return sqlSession.insert(namespace + "deptInsert", dept);
	}
	
	public int deptUpdate(DeptDTO dept) {
		logger.info("DeptDAOMybatis...deptUpdate()");
		return sqlSession.update(namespace + "deptUpdate", dept);
	}


	public int deptDelete(int deptid) {
		logger.info("DeptDAOMybatis...deptDelete()");
		return sqlSession.delete(namespace + "deptDelete", deptid);
	}

	
	public List<DeptDTO> selectByCondition(int deptid, String deptname, int mid, int lid) {

		return null;
	}

	
	private DeptDTO makeDept(ResultSet rs) throws SQLException {

		return null;
	}
}