import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int v = sc.nextInt();
		
		int day = 0; 
		
		if (a >= v) {
			day = 1;
			
		} else {
			if ((v-b) % (a-b) == 0) {
				day = (v-b) / (a-b);
				
			} else {
				day = (v-b) / (a-b) + 1;
			}
		}
		
		System.out.print(day);
		sc.close();
	}
}
