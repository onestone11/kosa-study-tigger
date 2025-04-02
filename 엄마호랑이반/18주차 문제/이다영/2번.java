package temp_dev;

import java.util.*;
import java.io.*;

public class Boj {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] drink = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			drink[i] = Integer.parseInt(st.nextToken());
		}
		
		Map<Integer, Integer> type = new HashMap<>();
		int cur = 0;
		for (int i = 0; i < k; i++) {
			type.put(drink[i], type.getOrDefault(drink[i], 0) + 1);
			if (type.get(drink[i]) == 1) cur++;
		}
		
		int maxType = cur;
		for (int i = k; i < n; i++) {
			type.put(drink[i], type.getOrDefault(drink[i], 0) + 1);
			if (type.get(drink[i]) == 1) cur++;
			
			type.put(drink[i-k], type.getOrDefault(drink[i], 0) - 1);
			if (type.get(drink[i-k]) == 0) cur--;
			
			maxType = Math.max(maxType, cur);
		}
		
		System.out.println(maxType);
	}
}
