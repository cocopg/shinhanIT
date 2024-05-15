import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 랜선 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선개수
		int N = Integer.parseInt(st.nextToken()); // 만들 랜선개수

		int[] arr = new int[K];

		long max = 0; // 랜선 최대길이
		
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		max ++; //max보다 최대값으로 해주기위함
		
		long min = 0;
		long mid = 0;

		while (min < max) {
			int cnt = 0;

			mid = (max + min) / 2;

			for (int i = 0; i < arr.length; i++) {
				cnt += (arr[i] / mid);
			}
			if (cnt < N) {
				max = mid; // 최대길이 감소
			} else {
				min = mid + 1; // 최소길이 증가
			}
		}
		System.out.println(min-1); //랜선 요구개수 만족하기 위한 값
	}

}
