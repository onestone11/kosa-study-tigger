import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GPT식숫자비교 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			list.add(br.readLine());
		}

		Collections.sort(list, (l1, l2) -> {

			int i1 = (int) Double.parseDouble(l1);
			int i2 = (int) Double.parseDouble(l2);

			// 정수부가 다르면 정수부로 비교
			if (i1 != i2) {
				return Integer.compare(i1, i2);
			}

			// 정수부가 같은 경우
			if (!l1.contains(".") && !l2.contains(".")) { // 둘 다 소수점이 없다 = 둘 다 정수다.
				return 0;
			} else if (!l1.contains(".")) { // l1만 소수점이 없다 = l2보다 l1이 무조건 작다.
				return -1;
			} else if (!l2.contains(".")) { // l2만 소수점이 없다 = l1보다 l2가 무조건 작다.
				return 1;
			}

			// 둘 다 소수점이 있는 경우
			String[] array1 = l1.split("\\.");
			String[] array2 = l2.split("\\.");

			int decimal1 = Integer.parseInt(array1[1]);
			int decimal2 = Integer.parseInt(array2[1]);

			return Integer.compare(decimal1, decimal2);
		});

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
