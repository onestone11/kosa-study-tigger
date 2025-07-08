class Solution {
    public long solution(int n) {
        // 최대 n이 2000까지 올 수 있으므로 길이 2001로 배열 생성
        int[] dp = new int[2001];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            // i칸을 가는 방법 = (i-1칸까지 가는 방법) + (i-2칸까지 가는 방법)
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
        }
        return dp[n];
    }
}
