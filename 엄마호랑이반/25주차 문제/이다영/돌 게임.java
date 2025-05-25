import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		String winner = n % 2 == 0 ? "CY" : "SK";
		
		System.out.println(winner);
		
		sc.close();
	}
}
