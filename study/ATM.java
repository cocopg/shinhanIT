import java.util.Arrays;
import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int time = 0;
		int answer = 0;
		for (int i = 0; i < N; i++) {
			time += arr[i];
			answer += time;
		}
		System.out.println(answer);

	}
}