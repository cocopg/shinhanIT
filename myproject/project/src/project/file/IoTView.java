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


}
