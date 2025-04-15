import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ25916_싫은데요 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] holes = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			holes[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		int sum = 0;
		int s = 0;
		int e = 0;
		
		while (e < N) {
			if (sum + holes[e] <= M) {
				sum += holes[e];
				max = Math.max(max, sum);
				e++;
			} else {
				sum -= holes[s];
				s++;
			}
			
//			System.out.println(s + " " + e + " " + sum);
		}

		System.out.println(max);

	}
}
