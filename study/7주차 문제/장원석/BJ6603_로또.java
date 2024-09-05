import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ6603_로또 {

	static int k;
	static int[] s;
	static boolean[] visit;
	static List<String> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if (k == 0)
				break;

			s = new int[k];
			for (int i = 0; i < k; i++) {
				s[i] = Integer.parseInt(st.nextToken());
			}

			list = new ArrayList<>();
			visit = new boolean[k];

			dfs(0, "", 0);

			StringBuilder sb = new StringBuilder();

			for (String s : list) {
				sb.append(s).append("\n");
			}
			System.out.println(sb.toString());
		}

	}

	private static void dfs(int depth, String str, int lastIndex) {
		if (depth == 6) {
			list.add(str);
			return;
		}

		String newStr;

		for (int i = lastIndex; i < k; i++) {
			if (visit[i])
				continue;

			visit[i] = true;

			if (depth == 0)
				newStr = String.valueOf(s[i]);
			else
				newStr = str + " " + s[i];

			dfs(depth + 1, newStr, i);

			visit[i] = false;
		}

	}
}
