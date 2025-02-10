package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16510_PredictableQueue {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] s = new int[N];

		st = new StringTokenizer(br.readLine());
		s[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			s[i] = Integer.parseInt(st.nextToken()) + s[i - 1];
		}

//		System.out.println(Arrays.toString(s));

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int time = Integer.parseInt(br.readLine());
			int left = 0;
			int right = N - 1;
			int result = -1;

			while (left <= right) {
				int mid = (left + right) / 2;

				if (s[mid] <= time) {
					result = mid;
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}

			sb.append(result + 1).append("\n");
		}

		System.out.println(sb.toString());
	}
}
