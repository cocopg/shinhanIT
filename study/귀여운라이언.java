import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 귀여운라이언 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());// 총인형개수
		int K = Integer.parseInt(st.nextToken());// 라이언인형갯수

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int minLen = Integer.MAX_VALUE;//최소부분 배열길이
		int start = 0;
		int cnt = 0;
		
		for(int end=0; end<N; end++) {//끝점이 움직여서 1이 나올때마다 cnt + 1
			if(arr[end] == 1) {
				cnt++;
			}
			while(cnt == K) {
				minLen = Math.min(minLen, (end - start +1));
				if(arr[start]==1) { //시작점이 움직여서 1이 나올때마다 cnt - 1
					cnt--;
				}
				start++;
			}
		}
		if(minLen == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(minLen);
		}

	}
	
	
}
