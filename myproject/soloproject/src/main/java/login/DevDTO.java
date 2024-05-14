package login;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
//DTO(Data Transfer Object)
//JavaBeans 기술에서 이용(Jsp,String, Mybatis는 JavaBeans기술을 이용한다)
public class DevDTO {
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("기기ID : ");
		builder.append(String.format("%-8s", device_id));
		builder.append("제조사 : ");
		builder.append(String.format("%-10s", manufacture));
		builder.append("종류 : ");
		builder.append(String.format("%-6s", d_type));
		builder.append("등록일 : ");
		builder.append(String.format("%-13s", regist_date));
		builder.append("전원 : ");
		builder.append(String.format("%-4s", status));
		builder.append("위치 : ");
		builder.append(String.format("%-5s", room_name));
		builder.append("사용자ID : ");
		builder.append(String.format("%-11s", user_id));
		return builder.toString();
	}

	private String device_id;
	private String manufacture;
	public String getDevice_id() {
		return device_id;
	}
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public String getD_type() {
		return d_type;
	}
	public void setD_type(String d_type) {
		this.d_type = d_type;
	}
	public Date getRegist_date() {
		return regist_date;
	}
	public void setRegist_date(Date regist_date) {
		this.regist_date = regist_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	private String d_type;
	private Date regist_date;
	private String status;
	private String room_name;
	private String user_id;
	private String password;
	
}