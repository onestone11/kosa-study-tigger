import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2506_점수계산 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] mark = new int[N + 1];
		mark[0] = -1;
		int totalScore = 0;
		int bonusScore = 1;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			mark[i] = Integer.parseInt(st.nextToken());

			if (mark[i] == 1) {
				if (mark[i] == mark[i - 1]) {
					bonusScore++;
				}

				totalScore += bonusScore;
			} else {
				bonusScore = 1;
			}
		}

		System.out.println(totalScore);
	}

}
