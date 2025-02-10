import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2467_용액_이분탐색 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Long[] s = new Long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			s[i] = Long.parseLong(st.nextToken());
		}

		int minLeft = 0;
		int minRight = 0;
		long min = Long.MAX_VALUE;

		for (int i = 0; i < N - 1; i++) {
			int left = i + 1;
			int right = N - 1;

			while (left <= right) {
				int mid = (left + right) / 2;
				long sum = Math.abs(s[i] + s[mid]);

				if (sum < min) {
					min = sum;
					minLeft = i;
					minRight = mid;
				}

				if (s[i] + s[mid] < 0) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}

		System.out.println(s[minLeft] + " " + s[minRight]);
	}

}
