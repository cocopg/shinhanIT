package project.file;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class ControlDAO {

	Connection conn;
	Statement st;
	PreparedStatement pst; // Statement를 상속받음, 바인딩변수 지원
	ResultSet rs;
	static Scanner sc = new Scanner(System.in);
	
	public List<LogDTO> deviceLog(LogDTO device) {
		List<LogDTO> devLoglist = new ArrayList<LogDTO>();
		String sql = "SELECT * FROM ActivityLog where device_id=?";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, device.getDevice_id());
			pst.executeUpdate();
			while (rs.next()) {
				LogDTO log = new LogDTO();
				log.setLog_id(rs.getInt("Log_ID"));
				log.setUser_id(rs.getString("User_ID"));
				log.setDevice_id(rs.getString("Device_id"));
				log.setTimestamp(rs.getString("Timestamp"));
				log.setStatus(rs.getString("Status"));
				devLoglist.add(log);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return devLoglist;
	}

	// 활동로그 출력
	public List<LogDTO> logAll() {
		List<LogDTO> loglist = new ArrayList<LogDTO>();
		String sql = "SELECT * FROM ActivityLog order by 1";
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				LogDTO log = new LogDTO();
				log.setLog_id(rs.getInt("Log_ID"));
				log.setUser_id(rs.getString("User_ID"));
				log.setDevice_id(rs.getString("Device_id"));
				log.setTimestamp(rs.getString("Timestamp"));
				log.setStatus(rs.getString("Status"));
				loglist.add(log);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return loglist;

	}

	// 기기삭제
	public int devDelete(DevDTO device) {
		int result = 0;
		String sql = "delete from DeviceInfo where Device_ID=? and Manufacture = ?";
		conn = DBUtil.dbConnection();
		try {

			pst = conn.prepareStatement(sql);
			pst.setString(1, device.getDevice_id());
			pst.setString(2, device.getManufacture());
			result = pst.executeUpdate(); // DML문장은 executeUpdate, select문은 executeQuery

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	// 기기추가
	public int devInsert(DevDTO device) {
		int result = 0;
		String sql = "INSERT INTO DeviceInfo VALUES (?, ?, ?, ?, ?, ?, ?)";
		conn = DBUtil.dbConnection(); // setAutoCommit(true)되어있
		try {
			pst = conn.prepareStatement(sql);
	        pst.setString(1, device.getDevice_id());
	        pst.setString(2, device.getManufacture());
	        pst.setString(3, device.getD_type());
	        pst.setDate(4, new Date(System.currentTimeMillis()));

	        // status가 "On"인 경우 1로, "Off"인 경우 0으로 처리
	        int statusValue = device.getStatus().equalsIgnoreCase("On") ? 1 : 0;
	        pst.setInt(5, statusValue);

	        pst.setString(6, device.getRoom_name());
	        pst.setString(7, device.getUser_id());
	        result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	// 예약정보
	public List<ResDTO> resList() {
		List<ResDTO> reslist = new ArrayList<ResDTO>();
		String sql = "SELECT * FROM TimeReservation order by 1";
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				ResDTO res = new ResDTO();
				res.setReservation_id(rs.getInt("Reservation_ID"));
				res.setDevice_id(rs.getString("Device_ID"));
				res.setStart_time(rs.getString("Start_Time"));
				res.setEnd_time(rs.getString("End_Time"));
				reslist.add(res);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return reslist;

	}

	// 예약삭제
	public int resDelete(int resId) {
		int result = 0;
		String sql = "delete from TimeReservation" + " where Reservation_ID=?";
		conn = DBUtil.dbConnection();
		try {

			pst = conn.prepareStatement(sql);
			pst.setInt(1, resId);
			result = pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	// 예약입력(insert)날짜
	public int resInsert(ResDTO res) {
		int result = 0;
		String sql = "insert into TimeReservation (Reservation_ID, Device_ID, Start_Time, End_Time) "
				+ "values (reservation_id_seq.nextval, ?, ?, ?)";
		conn = DBUtil.dbConnection(); // setAutoCommit(true)되어있
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, res.getDevice_id());
			pst.setString(2, res.getStart_time());
			pst.setString(3, res.getEnd_time());
			result = pst.executeUpdate(); // DML문장은 executeUpdate, select문은 executeQuery

			if (result > 0) {
				System.out.println("예약 성공!");
				System.out.println(res);
			} else {
				System.out.println("예약 실패! 잘못된 정보 입력");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	// 디바이스 on/off수정
	public int devUpdate(DevDTO device) {
		int result = 0;
		String sql = "update deviceinfo set status = ? where device_id = ?";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			
	        pst.setString(1, device.getDevice_id());
	        pst.setString(2, device.getStatus());
	        result = pst.executeUpdate();

			if (result > 0) {
				System.out.println("디바이스 상태 변경 성공!");
				System.out.println("현재 " + device.getDevice_id() + " 상태: " + device.getStatus());
			} else {
				System.out.println("디바이스 상태 변경 실패!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	// 디바이스 정보를 비교
	private boolean isCurrentDevice(DevDTO device) {
		String currentDeviceid = null;
		conn = DBUtil.dbConnection();
		String sql = "SELECT * FROM deviceinfo WHERE device_id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, device.getDevice_id());
			rs = pst.executeQuery();
			if (rs.next()) {
				currentDeviceid = rs.getString("device_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return currentDeviceid != null && currentDeviceid.equals(device.getDevice_id());
	}

	// 기기모두조회
	public List<DevDTO> selectAll() {
		List<DevDTO> devicelist = new ArrayList<DevDTO>();
		String sql = "select * from deviceinfo";
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				DevDTO device = makeDev(rs);
				devicelist.add(device);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return devicelist;

	}

	private DevDTO makeDev(ResultSet rs) throws SQLException {
		DevDTO device = new DevDTO();
		device.setDevice_id(rs.getString("device_id"));
		device.setManufacture(rs.getString("manufacture"));
		device.setD_type(rs.getString("d_type"));
		device.setRegist_date(rs.getDate("regist_date"));
		device.setStatus(rs.getString("status"));
		device.setRoom_name(rs.getString("room_name"));
		device.setUser_id(rs.getString("user_id"));
		return device;
	}
//	private ResDTO makeRes(ResultSet rs) {
//		ResDTO res = new ResDTO();
//		res.setDevice_id(rs.getString("device_id"));
//		res.setManufacture(rs.getString("manufacture"));
//		res.setD_type(rs.getString("d_type"));
//		res.setRegist_date(rs.getDate("regist_date"));
//		return res;
//	}

	private UserDTO makeUser(ResultSet rs) throws SQLException {
		UserDTO user = new UserDTO();
		user.setUser_id(rs.getString("user_id"));
		user.setPassword(rs.getString("password"));
		user.setName(rs.getString("name"));
		return user;
	}
	// 특정직원 1명 조회
//	private EmpDTO makeEmp(ResultSet rs) throws SQLException {
//		EmpDTO emp = new EmpDTO();
//		emp.setCommission_pct(rs.getDouble("commission_pct"));
//		emp.setDepartment_id(rs.getInt("department_id"));
//		emp.setEmail(rs.getString("email"));
//		emp.setEmployee_id(rs.getInt("employee_id"));
//		emp.setFirst_name(rs.getString("first_name"));
//		emp.setHire_date(rs.getDate("hire_date"));
//		emp.setJob_id(rs.getString("job_id"));
//		emp.setLast_name(rs.getString("last_name"));
//		emp.setManager_id(rs.getInt("manager_id"));
//		emp.setPhone_number(rs.getString("phone_number"));
//		emp.setSalary(rs.getInt("salary"));
//		return emp;
//	}
//
//	// 직원번호 이용해서 이름과 직책, 급여를 조회한다
//	public Map<String, Object> empInfo(int empid) {
//		Map<String, Object> empMap = new HashMap<>();
//		String fname = null, job = null;
//		int salary = 0;
//		String sql = "{call sp_empInfo(?,?,?,?)}";
//		CallableStatement cstmt = null;
//		conn = DBUtil.dbConnection();
//		try {
//			cstmt = conn.prepareCall(sql);
//			cstmt.setInt(1, empid);
//			cstmt.registerOutParameter(2, Types.VARCHAR);
//			cstmt.registerOutParameter(3, Types.VARCHAR);
//			cstmt.registerOutParameter(4, Types.VARCHAR);
//			boolean result = cstmt.execute();
//			fname = cstmt.getString(2);
//			job = cstmt.getString(3);
//			salary = cstmt.getInt(4);
//			empMap.put("fname", fname);
//			empMap.put("job", job);
//			empMap.put("salary", salary);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			DBUtil.dbDisconnect(conn, cstmt, rs);
//		}
//		return empMap;
//	}
//
//	// 직원번호가 들어오면 직원보너스를 return하는 함수를 호출한다.
//	public double callFunction(int empid) {
//		double bonus = 0;
//		String sql = "select f_bonus(?) from dual";
//		conn = DBUtil.dbConnection();
//		try {
//			pst = conn.prepareStatement(sql);
//			pst.setInt(1, empid);
//			rs = pst.executeQuery();
//			if (rs.next()) {
//				bonus = rs.getDouble(1);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return bonus;
//
//	}

}
