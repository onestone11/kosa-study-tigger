import java.util.*;
import java.io.*;

public class Main {
	private static int n;
	private static int[] liquid;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		liquid = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(liquid);
		int s = 0; int e = n-1;
		StringBuilder sb = new StringBuilder();
		long res = Long.MAX_VALUE;
		while (s < e) {
			long tmp = liquid[s] + liquid[e];
			
			if (Math.abs(tmp) <= res) {
				sb = new StringBuilder();
				sb.append(liquid[s]).append(" ").append(liquid[e]);
				
				res = Math.abs(tmp);
				
				if(tmp == 0) {
					break;
				}
			}
			
			if (tmp > 0) {
				e--;
				
			} else {
				s++;
			}
		}
		
		System.out.println(sb.toString());
		
	}
}
