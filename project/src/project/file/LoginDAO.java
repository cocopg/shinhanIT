package project.file;

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


public class LoginDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst; // Statement를 상속받음, 바인딩변수 지원
	ResultSet rs;

	// 1.로그인
	public String login(String user_id, String password) {
		conn = DBUtil.dbConnection();
		String userid = null;
		String sql = "select user_id, password\r\n" + "from users\r\n" + "where user_id=?\r\n" + "and password=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, user_id);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if (rs.next()) {
				userid = rs.getString("user_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return userid;
	}

	private UserDTO makeUser(ResultSet rs) {
		UserDTO user = new UserDTO();
		return user;
	}

	// 2.회원가입
	public boolean register(String user_id, String password, String name) {
		conn = DBUtil.dbConnection();
		boolean isSuccess = false;
		String checkExistingUserQuery = "SELECT COUNT(*) AS count FROM users WHERE user_id = ?";
		String insertUserQuery = "INSERT INTO users (user_id, password, name) VALUES (?, ?, ?)";

		try {
			// 중복된 사용자 확인
			pst = conn.prepareStatement(checkExistingUserQuery);
			pst.setString(1, user_id);
			rs = pst.executeQuery();
			rs.next();
			int count = rs.getInt("count");
			if (count > 0) {
				System.out.println("이미 존재하는 사용자입니다.");
			} else {
				// 새로운 사용자 추가
				pst = conn.prepareStatement(insertUserQuery);
				pst.setString(1, user_id);
				pst.setString(2, password);
				pst.setString(3, name);
				int rowsAffected = pst.executeUpdate();
				if (rowsAffected > 0) {
					isSuccess = true;
					System.out.println("회원가입이 완료되었습니다.");
				} else {
					System.out.println("회원가입에 실패했습니다. 다시 시도해주세요.");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return isSuccess;
	}

}
