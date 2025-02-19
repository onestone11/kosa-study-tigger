import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] study = new int[n+1];
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			
			int val = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			for(int j = n; j >= time; j--) {
				study[j] = Math.max(study[j], study[j - time] + val);
			}
		}
		
		System.out.print(study[n]);
	}
}
