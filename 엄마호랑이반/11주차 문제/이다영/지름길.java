import java.util.*;
import java.io.*;

public class Main {
	private static int n;
	private static int d;
	private static List<int[]> info;
	private static int res = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		info = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			info.add(new int[] {s, e, v});
		}
		Collections.sort(info, (o1, o2) -> o1[0] - o2[0]);

		go(0, 0, 0);
		
		System.out.println(res);
	}
	
	public static void go(int idx, int now, int dis) {
		if (now > d) return;
		
		if (idx == n) {
			dis += (d - now);
			res = Math.min(res, dis);
			
			return;
			
		} else {
			go(idx+1, now, dis);
			
			int[] next = info.get(idx);
			if (now <= next[0]) {
				dis += (next[0] - now) + next[2];
				now = next[1];
				
				go(idx+1, now, dis);
			}
			
		}
	}
}
