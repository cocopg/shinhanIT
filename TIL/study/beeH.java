package shinhanIT;

import java.util.Scanner;

public class beeH {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N =sc.nextInt();
		
		int roomN=1;
		
		int range=2;

		while(range<=N) {
			range=range+(6*roomN);
			roomN++;
		}
		System.out.println(roomN);
	}

}
