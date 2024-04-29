package com.shinhan.day14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1.jdbc driver를 class path추가
		// jdbc driver를 load
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("1.oracle driver load성공");

		// 2.DB연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe", userid = "hr", password = "hr";
		Connection conn = DriverManager.getConnection(url, userid, password);
		System.out.println("2.DB연결성공");
		String sql = "SELECT FIRST_NAME, SALARY, DEPARTMENT_ID FROM EMPLOYEES WHERE SALARY>=15000";
		//3.Statement : 자바와 DB의 대화통로
		Statement st = conn.createStatement();
		ResultSet rs =  st.executeQuery(sql);
		while(rs.next()) {
			String fname = rs.getString(1);
			int salary = rs.getInt(2);
			int deptid = rs.getInt(3);
			System.out.printf("%20s\t%d\t%d\n", fname, salary, deptid);
			
		}
		rs.close();
		st.close();
		conn.close();
	}

}

