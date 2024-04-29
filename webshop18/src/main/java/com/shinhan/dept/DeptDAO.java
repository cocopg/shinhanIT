package com.shinhan.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.emp.EmpDTO;
import com.shinhan.util.DBUtil;

public class DeptDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst; // Statement를 상속받음, 바인딩 변수 지원
	ResultSet rs;

	// 1. Create: 새 부서 생성
	public int deptInsert(DeptDTO dept) {
		int result = 0;
		String sql = "insert into departments values (?,?,?,?)";
		conn = DBUtil.dbConnection(); //setAutoCommit(true)되었음
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, dept.getDepartment_id());
			pst.setString(2, dept.getDepartment_name());
			pst.setInt(3, dept.getManager_id());
			pst.setInt(4, dept.getLocation_id());
			result = pst.executeUpdate(); // DML 문장은 executeUpdate, Select문은 execeuteQuery
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	

	// 2. Read: 부서 모두 조회
	public List<DeptDTO> selectAll() {
		List<DeptDTO> deptlist = new ArrayList<DeptDTO>();
		String sql = "select * from departments";
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				DeptDTO dept = makeDept(rs);
				deptlist.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return deptlist;

	}
	
	//특정 부서 조회
	public DeptDTO selectById(int deptid) {
		DeptDTO dept = null;
		String sql = "select * from departments where DEPARTMENT_ID=" + deptid;
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				dept = makeDept(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dept;
	}
	
	
	// 3. Update: 부서 정보 수정
	public int deptUpdate(DeptDTO dept) {
		int result = 0;
		String sql = "update departments "
				+ " set DEPARTMENT_NAME=?, "
				+ " MANAGER_ID=?, "
				+ " LOCATION_ID=? "
				+ " where DEPARTMENT_ID=? ";
		conn = DBUtil.dbConnection(); //setAutoCommit(true)되었음
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(4, dept.getDepartment_id());
			pst.setString(1, dept.getDepartment_name());
			pst.setInt(2, dept.getManager_id());
			pst.setInt(3, dept.getLocation_id());
			result = pst.executeUpdate(); // DML 문장은 executeUpdate, Select문은 execeuteQuery
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	// 4. Delete: 특정 부서 삭제
	public int deptDelete(int deptid) {
		int result = 0;
		String sql = "delete from departments "
				+ " where DEPARTMENT_ID=? ";
		conn = DBUtil.dbConnection(); //setAutoCommit(true)되었음
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, deptid);
			result = pst.executeUpdate(); // DML 문장은 executeUpdate, Select문은 execeuteQuery
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	private DeptDTO makeDept(ResultSet rs) throws SQLException {
		DeptDTO dept = new DeptDTO();

		dept.setDepartment_id(rs.getInt("department_id"));
		dept.setDepartment_name(rs.getString("department_name"));
		dept.setManager_id(rs.getInt("manager_id"));
		dept.setLocation_id(rs.getInt("location_id"));

		return dept;
	}
}