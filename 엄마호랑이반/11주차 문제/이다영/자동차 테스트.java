package temp_dev;

import java.util.*;
import java.io.*;

// 수정 -> 시간초과 남
public class Softeer {
	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 int n = Integer.parseInt(st.nextToken());
		 int q = Integer.parseInt(st.nextToken());
		 
		 TreeSet<Integer> cap = new TreeSet<>();
		 st = new StringTokenizer(br.readLine());
		 for (int i = 0; i < n; i++) {
			 cap.add(Integer.parseInt(st.nextToken()));
		 }
		 
		 int[] ans = new int[q];
		 for (int i = 0; i < q; i++) {
			 int x = Integer.parseInt(br.readLine());
			 
			 int idx = 0;
			 if (cap.contains(x)) idx = cap.headSet(x).size();
			 
			 ans[i] = idx * (n-1-idx); 
		 }
		 
		 for (int a : ans) {
			 System.out.println(a);
		 }
	}
}
