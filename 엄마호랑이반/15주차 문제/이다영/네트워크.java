import java.util.*;

class Solution {
    private int[] networks;
    public int solution(int n, int[][] computers) {
        networks = new int[n];
		for(int i = 0; i < n; i++) {
			networks[i] = i;
		}
		
		for(int i = 0; i <n; i++) {
			int[] com = computers[i];
			
			for(int j = 0; j < n; j++) {
				if (i != j && com[j] == 1) {
					union(i, j);
				}
			}
		}
		
		Set<Integer> set = new HashSet<>();
		for (int network : networks) {
			set.add(find(network));
		}
		
		return set.size();
    }
    
    public void union(int x, int y) {
		x = find(x);
		y = find(y);
        
		if (x != y) {
			networks[y] = x;
		}
	}
    
    public int find(int x) {
		if (networks[x] == x) {
			return x; 
		}
		
		return networks[x] = find(networks[x]);
	}
}
