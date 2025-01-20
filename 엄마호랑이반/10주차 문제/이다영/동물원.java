package temp_dev;

import java.util.*;
import java.io.*;

public class Boj {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 3;
		
		for(int i = 2; i < n + 1; i++) {
			dp[i] = ((dp[i-1] * 2) + dp[i-2]) % 9901;
		}
		
		System.out.print(dp[n]);
	}
	
}
