package project.file;

import java.util.List;
import java.util.Map;

//view는 사용자에게 어떻게 보여줄지를 담당, jsp로 작성예정
public class IoTView {

	public static void print(UserDTO users, String title) {
		System.out.printf("================================%s==============================\n", title);
	}

	public static void print(List<?> list, String title) {
	    System.out.printf("================================%s==============================\n", title);
	    list.forEach(item -> System.out.println(item));
	}

	public static void print(String message) {
        System.out.println(message);
    }

	

	

//	public static void print(EmpDTO emp, String title) {
//		System.out.printf("================%s==============\n", title);
//		if (emp == null) {
//			System.out.println("존재하지 않는 직원입니다.");
//		} else {
//
//			System.out.println("직원번호: " + emp.getEmployee_id());
//			System.out.println("이름: " + emp.getFirst_name());
//			System.out.println("성: " + emp.getLast_name());
//			System.out.println("급여: " + emp.getSalary());
//		}
//
//	}
//
//	public static void print(String message) {
//		System.out.printf("================%s==============\n", message);
//
//	}
//
//	public static void print(Map<String, Object> emp) {
//		for(String key:emp.keySet()) {
//			System.out.println(key+"==>"+emp.get(key));
//		}
//		
//	}

}
