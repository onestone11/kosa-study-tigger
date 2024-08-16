import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1654_랜선자르기 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] cables = new int[K];

		long max = 0;
		long min = 0;
		long mid = 0;

		for (int i = 0; i < K; i++) {
			cables[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, cables[i]);
		}

		max++;

		while (min < max) {
			mid = (max + min) / 2;

			long count = 0;

			for (int i = 0; i < K; i++) {
				count += cables[i] / mid;
			}

			if (count < N) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		
		System.out.println(min - 1);

	}

}
