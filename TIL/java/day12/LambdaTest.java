package com.shinhan.day12;

interface Calculable {
    double calc(double x, double y);
}

class MyCalculator implements Calculable {

	@Override
	public double calc(double x, double y) {

		return x + y;
	}
}

class Computer {
	public static double StaticMethod(double x, double y) {
		return x + y + 100;
	}

	 double instanceMethod(double x, double y) {
		return x + y + 200;
	}
}

interface Comparable2 {
	public abstract int compare(String a, String b);
}

interface Creatable {
	public Student create(String name, int score);
}

class Person {
	public Student getStudent(Creatable creatable, String name, int score) {
		return creatable.create(name, score);
	}
}

public class LambdaTest {

	public static void main(String[] args) {
		f5();

	}

	private static void f5() {
		Person p1 = new Person();
		Creatable creatable = new Creatable() {
			public Student create(String name, int score) {
				return new Student(name, score);
			}
		};
		// Creatable creatable2 = (String name, int score) ->new Student(name, score);
		Creatable creatable2 = Student::new;
		Student s = p1.getStudent(creatable2, "홍길동", 100);
		System.out.println(s);

	}

	private static void f4() {
		Student s = new Student("홍길동", 100);
		Student s2 = makeStudent("홍길동", 100);

	}

	private static Student makeStudent(String name, int score) {

		return new Student(name, score);
	}

	private static void f3() {
		String s1 = "b";
		String s2 = "a";
		// Comparable2 comp = (String a, String b)-> a.length() - b.length();
		// Comparable2 comp = ( a, b)-> a.length() - b.length();
		Comparable2 comp = String::compareToIgnoreCase;

		int result = comp.compare(s1, s2);
		System.out.println(result);

	}

	private static void f2() {
        System.out.println("1. 구현 class 이용");
        MyCalculator a = new MyCalculator();
        System.out.println("result = " + a.calc(1, 2));
        System.out.println("2. 익명 구현 객체 이용");
        Calculable b = new Calculable() {
            @Override
            public double calc(double x, double y) {
                return x - y;
            }
        };
        System.out.println("result = " + b.calc(1, 2));
        System.out.println("3. 람다식 이용");
        // Calculable c=(x, y) -> x*y;
        // Calculable c=Computer::staticMethod;
        Computer computer = new Computer();
        Calculable c = computer::instanceMethod;
        // Calculable c=Double::max;
        System.out.println("result = " + c.calc(1, 2));
    }
	private static void f1() {
		Thread t1 = new Thread() {
			public void run() {
				System.out.println("쓰레드를 구현한다.");
			}
		};
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("쓰레드구현...Runnable interface로 구현");

			}
		});
		Thread t3 = new Thread(() -> {
			System.out.println("쓰레드구현...Runnable interface로 구현");
		});

	}

}
