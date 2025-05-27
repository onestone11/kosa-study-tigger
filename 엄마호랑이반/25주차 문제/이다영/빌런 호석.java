import java.util.*;
import java.io.*;

public class Main {
	private static int n, k, p, x;
	private static Map<Integer, int[]> translate;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		setTranslate();
		
		int[] original = numToDigit(x);

		int answer = 0;
		for (int floor = 1; floor <= n; floor++) {
			if (floor == x) continue;

			int[] display = numToDigit(floor);
			int cnt = 0;

			for (int i = 0; i < k; i++) {
				int a = original[i];
				int b = display[i];

				if (a == b) continue;

				cnt += translate.get(a)[b];
				if (cnt > p) break;
			}

			if (1 <= cnt && cnt <= p) answer++;
		}

		System.out.println(answer);
	}
	
	// 숫자 x를 k자리 배열로 변환 (왼쪽 0 채움)
	// String.format().split()의 경우 호출 등으로 인한 연산량이 많아 숫자 연산만 사용
	private static int[] numToDigit(int x) {
		int[] result = new int[k];
		for (int i = k - 1; i >= 0; i--) {
			result[i] = x % 10;
			x /= 10;
		}
		return result;
	}
	
	private static void setTranslate() {
		translate = new HashMap<>();

		// key값에서 [val]로 이동하는 비용
		translate.put(0, new int[]{0, 4, 3, 3, 4, 3, 2, 3, 1, 2});
		translate.put(1, new int[]{4, 0, 5, 3, 2, 5, 6, 1, 5, 4});
		translate.put(2, new int[]{3, 5, 0, 2, 5, 4, 3, 4, 2, 3});
		translate.put(3, new int[]{3, 3, 2, 0, 3, 2, 3, 2, 2, 1});
		translate.put(4, new int[]{4, 2, 5, 3, 0, 3, 4, 3, 3, 2});
		translate.put(5, new int[]{3, 5, 4, 2, 3, 0, 1, 4, 2, 1});
		translate.put(6, new int[]{2, 6, 3, 3, 4, 1, 0, 5, 1, 2});
		translate.put(7, new int[]{3, 1, 4, 2, 3, 4, 5, 0, 4, 3});
		translate.put(8, new int[]{1, 5, 2, 2, 3, 2, 1, 4, 0, 1});
		translate.put(9, new int[]{2, 4, 3, 1, 2, 1, 2, 3, 1, 0});
	} 
}
