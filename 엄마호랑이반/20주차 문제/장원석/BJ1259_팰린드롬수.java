import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1259_팰린드롬수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String number = br.readLine();
		StringBuilder sb = new StringBuilder();

		while (!number.equals("0")) {
			StringBuilder reverse = new StringBuilder();
			reverse.append(number).reverse();

			if (number.equals(reverse.toString()))
				sb.append("yes").append("\n");
			else
				sb.append("no").append("\n");

			number = br.readLine();
		}
		
		System.out.println(sb.toString());
	}

}
