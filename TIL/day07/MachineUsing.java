package com.shinhan.day07;

public class MachineUsing {
	// field
	Machine v1 = new Machine() {

		@Override
		public void powerOn(String title) {
			System.out.println("2.익명으로 만들기");

		}
	};

	public static void main(String[] args) {
		Machine v2 = new Machine() {

			@Override
			public void powerOn(String title) {
				System.out.println("익명으로 만들기");

			}
		};

	}
}
