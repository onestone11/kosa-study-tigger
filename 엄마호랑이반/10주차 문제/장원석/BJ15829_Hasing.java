import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ15829_Hasing {

	static final int mod = 1234567891;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		long answer = 0;
		long pow = 1;

		String str = br.readLine();
		for (int i = 0; i < L; i++) {
			int toInt = str.charAt(i) - 'a' + 1;
			answer = (answer + (toInt * pow) % mod) % mod;
			pow = (pow * 31) % mod;
		}

		System.out.println(answer % mod);
	}

}
