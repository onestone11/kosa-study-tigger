class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
	dp[1][1] = 1;
	
	for (int[] puddle : puddles) {
		dp[puddle[1]][puddle[0]] = -1;
	}
	
	for (int x = 1; x < n + 1; x++) {
		for (int y = 1; y < m + 1; y++) {
			
			if(dp[x][y] != -1) {
				dp[x][y] += (dp[x-1][y] + dp[x][y-1]) % 1_000_000_007;
				
			} else {
				dp[x][y] = 0;
			}
		}
	}
	return dp[n][m] % 1_000_000_007;
    }
}
