package com.shinhan.day04;

public class EmployeeExam {

	public static void main(String[] args) {
		quest1();
		quest2();
		
	}

	private static void quest2() {
		Employee2 emp = new Employee2("123","홍길동",100);
		emp.setId("555");
		emp.setName("심은정");
		emp.setBaseSalary(200);
		System.out.println(emp.toString());
		System.out.println(emp);
		
	}

	private static void quest1() {
		Employee[] e = new Employee[4];
		Employee e1 = new Employee("이부장", "부장", 1500000);
		Employee e2 = new Employee("김과장", "과장", 1300000);
		Employee e3 = new Employee("최대리", "대리", 1200000);
		Employee e4 = new Employee("박사원", "사원", 1000000);
		
		e1.print();
		e2.print();
		e3.print();
		e4.print();
		
	}

}
