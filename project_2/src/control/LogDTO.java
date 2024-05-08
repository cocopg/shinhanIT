package control;

import java.sql.Timestamp;


public class LogDTO {
	private int log_id;
	private String user_id;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(log_id);
		builder.append(" 사용자ID : ");
		builder.append(String.format("%-11s", user_id));
		builder.append("기기ID : ");
		builder.append(String.format("%-8s", device_id));
		builder.append("시간 : ");
		builder.append(String.format("%-25s", timestamp));
		builder.append("전원상태 : ");
		builder.append(String.format("%-4s", status));
		return builder.toString();
	}
	public int getLog_id() {
		return log_id;
	}
	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getDevice_id() {
		return device_id;
	}
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String device_id;
	private String timestamp;
	private String status;
}
