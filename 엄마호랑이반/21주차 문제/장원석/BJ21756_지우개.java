import java.util.Scanner;

public class BJ21756_지우개 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int answer = 1;
		while (answer * 2 <= N) {
			answer *= 2;
		}

		System.out.println(answer);
	}
}
