import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ1620_나는야포켓몬마스터이다솜 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, Integer> map = new HashMap<>();
		String[] array = new String[N + 1];

		for (int i = 1; i <= N; i++) {
			String name = br.readLine();

			map.put(name, i);
			array[i] = name;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			String s = br.readLine();

			if (isNumber(s)) {
				sb.append(array[Integer.parseInt(s)]);
			} else {
				sb.append(map.get(s));
			}

			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	private static boolean isNumber(String s) {

		try {
			int i = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

}
