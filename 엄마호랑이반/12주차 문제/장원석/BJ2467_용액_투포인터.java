import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2467_용액_투포인터 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Long[] s = new Long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			s[i] = Long.parseLong(st.nextToken());
		}

		int left = 0;
		int right = N - 1;
		int minLeft = 0;
		int minRight = 0;
		long min = Long.MAX_VALUE;

		while (left < right) {
			long sum = s[left] + s[right];

			if (min > Math.abs(sum)) {
				min = Math.abs(sum);
				minLeft = left;
				minRight = right;
			}

			if (sum >= 0) {
				right--;
			} else {
				left++;
			}
		}

		System.out.println(s[minLeft] + " " + s[minRight]);
	}

}
