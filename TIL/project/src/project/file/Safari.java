package project.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Safari {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int sum = 0;
		if (N < 0 && M > 0) {
			sum += Math.abs(N) + M;
		} else if (N > 0 && M < 0) {
			sum += N + Math.abs(M);
		} else {
			int i = Math.abs(N - M);
			sum += i;
		}
		System.out.println(sum);
	}

}
