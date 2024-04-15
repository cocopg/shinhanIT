package project.file;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
 
public class IoTController {
	static Scanner sc = new Scanner(System.in);
	static LoginDAO loginDAO = new LoginDAO();
	static String isLogin;
	public static void main(String[] args) {
		boolean loginStop = false;
		while (!loginStop) {
			int loginjob = startDisplay();
			switch (loginjob) {
			case 0 -> {
				loginStop = true;
			}
			case 1 -> {
				int loginCount = 3;
				isLogin = loginDisplay();
				for (int i = 3; i > 1; i--) {
					if (isLogin == null && loginCount > 0) {
						if (isLogin == null) {
							System.out.println("아이디 또는 비밀번호가 틀렸습니다");
							loginCount--;
							System.out.println("남은 로그인 시도 횟수는 " + loginCount + "입니다.");
						}
						isLogin = loginDisplay();
					}
				}
				if (isLogin != null) {
					System.out.println("로그인성공!");
					System.out.println("사용자 ID: " + isLogin);
					loginStop = true;

				} else {
					System.out.println("3회 실패해서 프로그램을 종료합니다.");
					return;
				}
			}
			case 2 -> {
				boolean isRegistered = registerDisplay();
//				

			}
			default->{
				System.out.println("잘못된 입력입니다. 올바르게 입력하세요.");
			}
			}
		}

		boolean isStop = false;
		IoTService iotService = new IoTService();
		while (!isStop) {
			int selectJob = menuDisplay();
			switch (selectJob) {
			case 0 -> {
				isStop = true;
			}
			case 1 -> {
				List<DevDTO> devicelist = iotService.selectAll();
				IoTView.print(devicelist, "모든기기 조회");
			}
			case 2 -> {
				DevDTO device = insertMenu(); // 기기명 입력 받기
				int result = iotService.devUpdate(device);
			}
			case 3 -> {
				int sJob = resMenu();
				switch (sJob) {
				case 1 -> {
					ResDTO res = insertResMenu();
					int result = iotService.resInsert(res);
				}
				case 2 -> {
					System.out.print("삭제할 예약번호>>");
					int resid = sc.nextInt();
					int result = iotService.resDelete(resid);
					IoTView.print(result > 0 ? "삭제성공" : "존재하지 않는 예약번호입니다");

				}
				case 3 -> {
					List<ResDTO> reslist = iotService.resList();
					IoTView.print(reslist, "예약내역 조회");
				}
				default -> {
				}
				}

			}
			case 4 -> {
				int dJob = devMenu();
				switch (dJob) {
				case 1 -> {
					DevDTO device = insertDevMenu();
					int result = iotService.devInsert(device);
					IoTView.print(result > 0 ? "입력성공" : "입력실패");

				}
				case 2 -> {
					System.out.print("삭제할 기기ID>>");
					String deviceid = sc.next();
					System.out.print("제조사 입력>>");
					String manufacture = sc.next();

					DevDTO device = new DevDTO();
					device.setDevice_id(deviceid);
					device.setManufacture(manufacture);

					int result = iotService.devDelete(device);
					IoTView.print(result > 0 ? "삭제성공" : "존재하지 않는 기기이거나 정보가 일치하지 않습니다.");
				}
				}

			}
			case 5 -> {
					List<LogDTO> loglist = iotService.logAll();
					IoTView.print(loglist, "활동로그 조회");
			}
			default -> {
				System.out.println("잘못된 입력입니다. 올바르게 입력하세요.");
			}
			}
		}
		System.out.println("========END=========");
	}

	

	private static DevDTO insertDevMenu() {
		System.out.println("------------------------");
		System.out.println("         기기 추가");
		System.out.println("------------------------");
		System.out.print("기기명을 입력하세요>>");
		String deviceid = sc.next();
		System.out.print("제조사를 입력하세요>>");
		String manuf = sc.next();
		System.out.print("종류입력>>");
		String dtype = sc.next();
		System.out.print("상태입력>>");
		String status = sc.next();
		System.out.print("위치입력>>");
		String rname = sc.next();

		DevDTO device = new DevDTO();
		device.setDevice_id(deviceid);
		device.setManufacture(manuf);
		device.setD_type(dtype);
		device.setStatus(status);
		device.setRoom_name(rname);
		device.setUser_id(isLogin);
		return device;
	}

	private static int devMenu() {
		System.out.println("------------------------");
		System.out.println("1.기기등록하기 | 2.기기삭제하기");
		System.out.println("------------------------");
		int job = sc.nextInt();
		return job;
	}

	private static IoTService iotService = new IoTService();

	private static int resMenu() {
		System.out.println("-----------------------------");
		System.out.println("1.예약하기 | 2.예약취소 | 3.예약내역");
		System.out.println("-----------------------------");
		int job = sc.nextInt();
		return job;
	}

//	private static ResDTO cancelMenu() {
//		System.out.println("=======취소하기======");
//		System.out.println("예약번호>>");
//		int reservationId = sc.nextInt();
//
//		ResDTO res = new ResDTO();
//		res.setReservation_id(reservationId);
//		return res;
//	}

	private static ResDTO insertResMenu() {
		Scanner sc = new Scanner(System.in);
//	    System.out.println("예약번호>>");
//	    int resid = sc.nextInt();
		System.out.println("=======예약하기======");
		System.out.println("기기ID>>");
		String deviceid = sc.nextLine();
		System.out.println("시작시간(형식: yyyy-mm-dd hh:mm:ss)>>");
		String stime = sc.nextLine();
		System.out.println("종료시간(형식: yyyy-mm-dd hh:mm:ss)>>");
		String etime = sc.nextLine();

		try {

		} catch (IllegalArgumentException e) {
			// 입력 형식이 잘못됨
			System.out.println("입력된 형식이 잘못되었습니다. 다시 입력해주세요.");
			return insertResMenu();// 재입력
		}

		ResDTO res = new ResDTO();
//	    device.setReservation_id(resid);
		res.setDevice_id(deviceid);
		res.setStart_time(stime);
		res.setEnd_time(etime);
		return res;
	}

	private static String loginDisplay() {
		System.out.println("=======로그인=======");
		System.out.print("아이디 입력:");
		String user_id = sc.next();
		System.out.print("비밀번호 입력:");
		String password = sc.next();
		return loginDAO.login(user_id, password);

	}

	private static boolean registerDisplay() {
		System.out.println("=======회원가입=======");
		System.out.print("사용자 ID 입력:");
		String user_id = sc.next();
		System.out.print("비밀번호 입력:");
		String password = sc.next();
		System.out.print("이름 입력:");
		String name = sc.next();
		return loginDAO.register(user_id, password, name);
	}

	private static int startDisplay() {
		System.out.println("=======IoT서비스=======");
		System.out.println("1.로그인");
		System.out.println("2.회원가입");
		System.out.print("작업선택>>");
		int job = sc.nextInt();
		return job;
	}

	private static DevDTO insertMenu() {
		System.out.println("-----------------");
		System.out.println("  디바이스 on/off");
		System.out.println("-----------------");
		System.out.print("기기명을 입력하세요>>");
		String deviceid = sc.next();
//		System.out.println("Manufacture>>");
//		String manuf = sc.next();
//		System.out.println("D_type>>");
//		String dtype = sc.next();
//		System.out.println("Regist_Date>>");
//		Date rdate = DateUtil.getSQLDate(sc.next());
//		System.out.println("Room_Name>>");
//		String rname = sc.next();
		System.out.print("상태변경>>");
		String status = sc.next();
//		System.out.println("User_ID>>");
//		String userid = sc.next();

		DevDTO device = new DevDTO();
		device.setDevice_id(deviceid);
//		device.setManufacture(manuf);
//		device.setD_type(dtype);
//		device.setRegist_date(rdate);
//		device.setRoom_name(rname);
		device.setStatus(status);
//		device.setUser_id(userid);
		return device;
	}

	private static int menuDisplay() {
		System.out.println("-----------------------메인메뉴---------------------");
		System.out.println("1.등록 디바이스 확인 | 2.디바이스on/off | 3.동작시간 예약/취소");
		System.out.println("4.디바이스 추가/삭제 | 5.디바이스로그 확인 | 0.프로그램 종료");
		System.out.println("--------------------------------------------------");
		System.out.print("작업선택>>");
		int job = sc.nextInt();
		return job;

	}
}