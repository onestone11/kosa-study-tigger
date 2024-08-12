import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BJ11478_서로다른부분문자열의개수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		Set<String> set = new HashSet<>();
		int answer = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				String sub = s.substring(i, j);
				set.add(sub);
			}
		}
		
		System.out.println(set.size());
	}

}
