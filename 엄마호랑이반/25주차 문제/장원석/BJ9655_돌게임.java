import java.util.Scanner;

public class BJ9655_돌게임 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		if(N % 2 == 0) {
			System.out.println("CY");
		} else {
			System.out.println("SK");
		}
	}
}
