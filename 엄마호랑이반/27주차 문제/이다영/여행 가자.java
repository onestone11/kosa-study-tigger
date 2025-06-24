import java.util.*;
import java.io.*;

public class Main {
	private static int[] city;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());  // 여행 계획에 포함된 도시의 수
		
		// 초기화
		city = new int[n];
		for(int i = 0; i < n; i++) {
			city[i] = i;
		}
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < n; j++) {
				int now = Integer.parseInt(st.nextToken());
				
				// 도시 연결
				if(now == 1) { 
					union(i, j);
				}
			}
		}
		
		String ans = "YES";
		StringTokenizer st = new StringTokenizer(br.readLine());
		int std = Integer.parseInt(st.nextToken()) - 1;
		while(st.hasMoreTokens()) {
			int com = Integer.parseInt(st.nextToken()) - 1;
			
			if(find(std) != find(com)) {
				ans = "NO";
				break;
			}
		}
		
		System.out.print(ans);
	}
	
	private static void union(int x, int y) {
		int xx = find(x);
		int yy = find(y);
		
		if(xx != yy) {
			city[yy] = xx;
		}
	}
	
	private static int find(int x) {
		if (x == city[x]) return x;
		
		return city[x] = find(city[x]);
	}

}
