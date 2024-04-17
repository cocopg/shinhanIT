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
	PreparedStatement pst;
	ResultSet rs;
	//삭제
	public int deptDelete(int deptid) {
		int result = 0;
		String sql = "delete from employees" 
				+ " where DEPARTMENT_ID=?";
		conn = DBUtil.dbConnection();
		try {

			pst = conn.prepareStatement(sql);
			pst.setInt(1, deptid);
			result = pst.executeUpdate(); // DML문장은 executeUpdate, select문은 executeQuery

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	// 7.수정(Update)
	public int empUpdate(EmpDTO emp) {
		int result = 0;
		String sql = "--";
		conn = DBUtil.dbConnection();
		try {

			pst = conn.prepareStatement(sql);
			pst.setInt(11, emp.getEmployee_id());
			pst.setString(1, emp.getFirst_name());
			pst.setString(2, emp.getLast_name());
			pst.setString(3, emp.getEmail());
			pst.setString(4, emp.getPhone_number());
			pst.setDate(5, emp.getHire_date());
			pst.setString(6, emp.getJob_id());
			pst.setInt(7, emp.getSalary());
			pst.setDouble(8, emp.getCommission_pct());
			pst.setInt(9, emp.getManager_id());
			pst.setInt(10, emp.getDepartment_id());
			result = pst.executeUpdate(); // DML문장은 executeUpdate, select문은 executeQuery

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	// 6.입력(insert)
	public int empInsert(EmpDTO emp) {
		int result = 0;
		String sql = "--";
		conn = DBUtil.dbConnection(); // setAutoCommit(true)되어있
		try {

			pst = conn.prepareStatement(sql);
			pst.setInt(1, emp.getEmployee_id());
			pst.setString(2, emp.getFirst_name());
			pst.setString(3, emp.getLast_name());
			pst.setString(4, emp.getEmail());
			pst.setString(5, emp.getPhone_number());
			pst.setDate(6, emp.getHire_date());
			pst.setString(7, emp.getJob_id());
			pst.setInt(8, emp.getSalary());
			pst.setDouble(9, emp.getCommission_pct());
			pst.setInt(10, emp.getManager_id());
			pst.setInt(11, emp.getDepartment_id());
			result = pst.executeUpdate(); // DML문장은 executeUpdate, select문은 executeQuery

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	//2.특정지역 인원조회
	public List<DeptDTO> selectBylocid(int locid) {
		List<DeptDTO> deptlist = new ArrayList<DeptDTO>();
		String sql = "select * from employees where location_id =?";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, locid);
			rs = pst.executeQuery();
			while (rs.next()) {
				DeptDTO dept = makeDept(rs);
				deptlist.add(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return deptlist;

	}
	
	
	// 1.전부조회
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBUtil.dbDisconnect(conn, st, rs);
			}
			return deptlist;

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
