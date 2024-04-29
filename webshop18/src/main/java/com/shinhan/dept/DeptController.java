package com.shinhan.dept;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import com.shinhan.util.DateUtil;

public class DeptController {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean isStop = false;
		DeptService deptService = new DeptService();
		while (!isStop) {
			int selectDept = menuDisplay();
			switch (selectDept) {
			case 0 -> {
				isStop = true;
			}
			case 1 -> {
				List<DeptDTO> deptlist = deptService.selectAll();
				DeptView.print(deptlist, "모든직원조회");
			}
			case 2 -> {
				System.out.println("조회할 지역번호");
				int locid = sc.nextInt();
				DeptView.print(deptService.selectBylocid(locid), "특정직원조회");
			}
			default -> {
			}
			}

		}
		System.out.println("----------END----------");
	}

//	private static DeptDTO insertMenu() {
//		System.out.println("DEPARTMENT_ID>>");
//		int empid = sc.nextInt();
//		System.out.println("DEPARTMENT_NAME>>");
//		String fname = sc.next();
//		System.out.println("MANAGER_ID>>");
//		String lname = sc.next();
//		System.out.println("LOCATION_ID>>");
//		
//		DeptDTO dept = new DeptDTO();
//		dept.setDepartment_id(deptid);
//		dept.setDepartment_name_id(deptname);
//		dept.setManager_id(mngid);
//		dept.setLocation_id(locid);
//		
//		
//		return dept;
//	}

	private static int menuDisplay() {
		System.out.println("==================");
		System.out.println("1.전체 조회");
		System.out.println("2.특정지역 인원조회");
		System.out.println("3.입력");
		System.out.println("4.수정");
		System.out.println("5.삭제");
		System.out.println("0.종료");
		System.out.println("작업선택>>");
		System.out.println("==================");
		int dept = sc.nextInt();
		return dept;
	}
}
