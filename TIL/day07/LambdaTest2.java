package com.shinhan.day07;

//람다표현식 가능한지 체크
//추상메서드가 반드시 1개일 때만 가능하다.
@FunctionalInterface
interface Calculable {
	public abstract void calculate(int x, int y);
}

//매개변수가 있고 return이 있는 경우
@FunctionalInterface
interface Calculable2 {
	abstract int calculate2(int x, int y);
}

public class LambdaTest2 {

	public static void main(String[] args) {
		call2(new Calculable2() {

			@Override
			public int calculate2(int x, int y) {
				return x + y;
			}
		});
		call2((x, y) -> x - y);
		call2((x, y) -> {
			System.out.println("문장이 여러개이면{}로묶는다. return있으면 반드시 return");
			return x - y;
		});
		call2((left, right) -> left > right ? left : right);
		call2((left, right) -> Math.max(left, right));
		
		//static method를 사용하는 경우
		call2(Math::max);
		
		//instance method를 사용하는 경우
		
		
		
	}

	private static void call2(Calculable2 cal) {
		int result = cal.calculate2(10, 6);
		System.out.println(result);
	}

	public static void f(String[] args) {
		call(new Calculable() {
			public void calculate(int x, int y) {
				System.out.println("익명구현 class x+y= " + x + y);
			}
		});
		call((x, y) -> System.out.println("람다식 x+y= " + (x + y)));
		call((a, b) -> {
			System.out.println("-------------");
			System.out.println("람다식 a*b= " + (a * b));
			System.out.println("-------------");
		});
	}

	private static void call(Calculable cal) {
		cal.calculate(1, 2);

	}

}
