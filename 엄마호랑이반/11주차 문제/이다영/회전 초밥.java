import java.util.*;
import java.io.*;

public class Boj {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] dishes = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			dishes[i] = Integer.parseInt(st.nextToken());
		}
		
		int res = 0;
		boolean[] sushi;
		for(int i = 0; i < n; i++) {
			sushi = new boolean[d+1];
			int ate = 0;
			int coupon = 1;
			
			for (int j = i; j < i + k; j++) {
				if (sushi[dishes[j % n]]) {
					ate++;
					
				} else {
					sushi[dishes[j % n]] = true;
				}
				
				if (dishes[j % n] == c) coupon = 0;
			}
			
			res = Math.max(res, k - ate + coupon);
		}
		
		System.out.println(res);
	}
}
