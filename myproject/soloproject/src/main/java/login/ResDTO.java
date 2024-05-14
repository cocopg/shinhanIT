package login;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
public class ResDTO {
	private int reservation_id;
	private String device_id;
	private String start_time;
	private String end_time;

	public ResDTO(String deviceid, String start, String end) {
		this.device_id = deviceid;
		this.start_time = start;
		this.end_time = end;
		
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("%-5s", reservation_id));
		builder.append("기기ID : ");
		builder.append(String.format("%-8s", device_id));
		builder.append("시작시간 : ");
		builder.append(String.format("%-25s", start_time));
		builder.append("종료시간 : ");
		builder.append(String.format("%-25s", end_time));
		return builder.toString();
	}

	public int getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}

	public String getDevice_id() {
		return device_id;
	}

	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

}
