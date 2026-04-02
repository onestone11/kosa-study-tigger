import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11399_ATM {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int P[] = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(P);
		int sum = 0;
		int S[] = new int[N + 1];

		for (int i = 0; i < N; i++) {
			S[i + 1] = S[i] + P[i];
			sum += S[i + 1];
		}

		System.out.println(Arrays.toString(P));
		System.out.println(Arrays.toString(S));

		System.out.println(sum);
	}

}
