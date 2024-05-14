package com.shinhan.emp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcLab {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean isStop = false;

		while (!isStop) {
			int selectJob = menu();
			switch (selectJob) {
			case 1 -> {
				String sql = "SELECT HIRE_DATE, SALARY\r\n" + "FROM EMPLOYEES\r\n"
						+ "WHERE FIRST_NAME = INITCAP('adam')";
				method1(sql);
			}
			case 2 -> {
				String sql = "SELECT REGION_ID\r\n" + "FROM COUNTRIES\r\n"
						+ "WHERE LOWER(COUNTRY_NAME) = 'united states of america'";
				method2(sql);
			}
			case 3 -> {
				String sql = "SELECT FIRST_NAME||'의 입사일은'||HIRE_DATE||'이고, 급여는'||SALARY||'입니다.'\r\n" + "FROM EMPLOYEES";
				method3(sql);
			}
			case 4 -> {
				String sql = "select first_name, salary, hire_date\r\n" + "from employees\r\n"
						+ "where length(first_name) <= 5";
				method4(sql);
			}
			case 5 -> {
				String sql = "select FIRST_NAME, HIRE_DATE\r\n" + "from EMPLOYEES\r\n"
						+ "where to_char(HIRE_DATE, 'yyyy') = '2006";
				method5(sql);
			}
			case 6 -> {
				String sql = "SELECT FIRST_NAME, HIRE_DATE, SALARY, TRUNC (months_between (sysdate, hire_date)/12 )년차\r\n"
						+ "FROM EMPLOYEES\r\n" + "WHERE MONTHS_BETWEEN(SYSDATE ,HIRE_DATE)/12>=7";
				method6(sql);
			}
			case 7 -> {
				isStop = true;
			}
			default -> {
				System.out.println("실수했네...짜식ㅋ 담엔 잘골라라");
			}
			}

		}
		System.out.println("시스템 종료");

	}

	private static void method6(String sql) {
		Connection conn = dbConnection();
		try {
			Statement st = conn.createStatement();

			System.out.print("근무년수 몇년이상?>");
			int su = sc.nextInt();

			ResultSet rs = st.executeQuery(sql + su);
			int i = 0;
			while (rs.next()) {
				i++;
				String name = rs.getString(1);
				int sal = rs.getInt(3);
				Date hdate = rs.getDate(2);

				System.out.println(i + "==>" + name + "\t" + sal + "\t" + hdate);
			}
			dbDisconnect(conn, st, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void method5(String sql) {
		Connection conn = dbConnection();
		try {
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString(1);
				Date hdate = rs.getDate(2);
				System.out.println(name + "입사일: " + hdate);
			}
			dbDisconnect(conn, st, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void method4(String sql) {
		Connection conn = dbConnection();

		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			int i = 0;
			while (rs.next()) {
				i++;
				String name = rs.getString(1);
				int sal = rs.getInt(2);
				Date hdate = rs.getDate(3);
				System.out.println(name + ":" + sal + "원" + "\t" + hdate);
			}
			dbDisconnect(conn, st, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void method3(String sql) {
		Connection conn = dbConnection();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String info = rs.getString(1);
				System.out.println(info);
			}
			dbDisconnect(conn, st, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void method2(String sql) {
		Connection conn = dbConnection();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int rgId = rs.getInt(1);
				System.out.println(rgId);
			}
			dbDisconnect(conn, st, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void method1(String sql) {

		Connection conn = dbConnection();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Date hdate = rs.getDate(1);
				int sal = rs.getInt(2);
				System.out.println(sal + "\t" + hdate);
			}
			dbDisconnect(conn, st, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void dbDisconnect(Connection conn, Statement st, ResultSet rs) throws SQLException {
		rs.close();
		st.close();
		conn.close();
		System.out.println("3.실행 후 DB해제");

	}

	private static Connection dbConnection() {
		// 1.jdbc driver를 load
		// 2.connection생성
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "hr";
		String password = "hr";
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. JDBC Driver Load Success");
			conn = DriverManager.getConnection(url, userid, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	private static int menu() {
		System.out.println("=======================================");
		System.out.println("1.INITCAP 2.LOWER 3.CONCAT 4.LENGTH");
		System.out.println("5.TO_CHAR 6.MONTHS_BETWEEN 7.END");
		System.out.print("작업을 선택>");
		int job = sc.nextInt();
		System.out.println("=======================================");

		return job;
	}

}
