package com.shinhan.day08;

//규격서
@FunctionalInterface //람다표현식 가능여부 체크
interface JDBCInterface{
	//1.상수
	//2.추상메서드...추상메서드는 구현 class가 반드시 구현해야한다.
	public abstract void connection();
	//3.default 메서드 : 구현가능, 구현class가 공통적으로 사용하는 기능, 재정의가능
	//4.static 메서드: 구현, 구현class가 공통적으로 사용하는 기능, 재정의 불가능
	//5.private 메서드: default 메서드에서만 호출가능.
	
}
//구현class만들기
class OracleDB implements JDBCInterface {

	@Override
	public void connection() {
		System.out.println("OracleDB 연결합니다.");
	}
	
}
class MySQLDB implements JDBCInterface {

	@Override
	public void connection() {
		System.out.println("MySQLDB 연결합니다.");
	}
	
}


public class Review {

	public static void main(String[] args) {
		work(new OracleDB());
		work(new MySQLDB());
		
		work(new JDBCInterface() {

			@Override
			public void connection() {
				System.out.println("익명구현class에서 메서드 재정의함");
				method();
			}
			void method() {
				System.out.println("메서드추가함");
			}
			
		});
		work(()->System.out.println("람다표현식으로 메서드 재정의함"));
	}

	private static void work(JDBCInterface db) {
		db.connection();
		
		
	}

}
