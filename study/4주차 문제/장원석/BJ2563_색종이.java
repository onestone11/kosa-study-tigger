import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2563_색종이 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		boolean[][] paper = new boolean[101][101];
		int cnt = 0;

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					if(!paper[i][j]) {
						paper[i][j] = true;
						cnt++;
					}
				}
			}
		}
		
		System.out.println(cnt);

	}

}
