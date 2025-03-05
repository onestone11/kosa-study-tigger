import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int cnt = 0;
		String title = "";
		for (int i = 666; i < Integer.MAX_VALUE; i++) {
			String now = String.valueOf(i);
			if (now.contains("666")) {
				cnt++;
				title = now;
			}
			
			if(cnt == n) break;
		}
		
		System.out.print(title);
		sc.close();
	}
}
