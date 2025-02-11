import java.util.*;
import java.io.*;

public class Main {
	private static int n;
	private static int[] home;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		home = new int[n];
		for (int i = 0; i < n; i++) {
			home[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(home);
		
		int s = 1; int e = home[n-1];
		int res = 0;
		while (s <= e) {
			int mid = (s + e) / 2;
			
			if (findCount(mid) >= c) {
				res = mid;
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}
		
		System.out.println(res);
		
	}
	
	public static int findCount(int len) {
		int cnt = 1;
		int end = home[0];
		
		for (int i = 1; i < n; i++) {
			if (home[i] - end >= len) {
				cnt++;
				end = home[i];
			}
		}
		
		return cnt;
	}
	
}
