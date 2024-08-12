import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ16937_두스티커 {

	static int H, W, N;
	static List<int[]> list = new ArrayList<>();
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			if ((R <= H && C <= W) || (R <= W && C <= H))
				list.add(new int[] { R, C });
		}

		for (int[] is : list) {
			System.out.println(Arrays.toString(is));
		}

		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				int[] sticker1 = list.get(i);
				int[] sticker2 = list.get(j);

				checkSticker(sticker1[0], sticker1[1], sticker2[0], sticker2[1]);
				checkSticker(sticker1[0], sticker1[1], sticker2[1], sticker2[0]);
				checkSticker(sticker1[1], sticker1[0], sticker2[0], sticker2[1]);
				checkSticker(sticker1[1], sticker1[0], sticker2[1], sticker2[0]);
			}
		}

		System.out.println(ans);
	}

	public static void checkSticker(int h1, int w1, int h2, int w2) {
		// 가로 배치
		if ((h1 + h2 <= H && Math.max(w1, w2) <= W) || (h1 + h2 <= W && Math.max(w1, w2) <= H)) {
			ans = Math.max(ans, h1 * w1 + h2 * w2);
		}

		// 세로 배치
		if ((Math.max(h1, h2) <= H && w1 + w2 <= W) || (Math.max(h1, h2) <= W && w1 + w2 <= H)) {
			ans = Math.max(ans, h1 * w1 + h2 * w2);
		}
	}
}
