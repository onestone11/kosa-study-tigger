import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2230
 * 골드5 수 고르기
 */

public class BJ2230_수고르기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] A = new int[N];

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(A);
		int s = 0;
		int e = 1;
		int min = Integer.MAX_VALUE;

		while (s < N && e < N) {

			int sub = A[e] - A[s];

			if (sub < M) {
				e++;
			} else if (sub > M) {
				min = Math.min(min, sub);
				s++;
			} else {
				min = Math.min(min, sub);
				break;
			}

		}

		System.out.println(min);
	}

}
