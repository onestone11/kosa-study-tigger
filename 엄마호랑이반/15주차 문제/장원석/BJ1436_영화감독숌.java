import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1436_영화감독숌 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int count = 0;
		int number = 666;

		while (true) {
			if (String.valueOf(number).contains("666")) {
				count++;
			}

			if (count == N) {
				System.out.println(number);
				break;
			}

			number++;
		}
	}
}
