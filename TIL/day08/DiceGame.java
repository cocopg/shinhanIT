package com.shinhan.day08;

public class DiceGame {
	public static void main(String args[]) {
		DiceGame game = new DiceGame();

		int result1 = game.countSameEye(10);
		System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result1);

		int result2 = game.countSameEye(-10);
		System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result2);

	}

	int countSameEye(int n) {
		
		if(n<0) throw new IllegalArgumentException("던지는 횟수는 음수가 될 수 없음");
		Dice d1 = new Dice(8);
		Dice d2 = new Dice(8);
		int count = 0;
		for(int i = 1; i<=n;i++) {
			int su1 = d1.play();
			int su2 = d2.play();
			if(su1 ==su2) count++;
			System.out.println(su1+"--"+su2);
		}
		return count;
	}
}
