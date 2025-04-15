import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10942_팰린드롬물음표 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		boolean[][] palindrome = new boolean[N][N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			palindrome[i][i] = true;
		}

		for (int i = 0; i < N - 1; i++) {
			if (array[i] == array[i + 1]) {
				palindrome[i][i + 1] = true;
			}
		}

		for (int i = N - 2; i >= 0; i--) {
			for (int j = i + 2; j < N; j++) {

//				System.out.println(i + " " + j);

				if (array[i] == array[j] && palindrome[i + 1][j - 1]) {
					palindrome[i][j] = true;
				}
			}
		}

//		for (int i = 0; i < palindrome.length; i++) {
//			for (int j = 0; j < palindrome.length; j++)
//				System.out.print(palindrome[i][j] + " ");
//			System.out.println();
//		}

		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken()) - 1;
			int E = Integer.parseInt(st.nextToken()) - 1;
			
			if(palindrome[S][E])
				sb.append(1).append("\n");
			else
				sb.append(0).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
