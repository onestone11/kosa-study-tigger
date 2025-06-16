class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long left = 0;
        long right = (long) 1e15;
        long answer = right;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            long totalGold = 0;
            long totalSilver = 0;
            long totalWeight = 0;
            
            for (int i = 0; i < g.length; i++) {
                long time = t[i];
                long maxMove = mid / (2 * time);
                if (mid % (2 * time) >= time) maxMove++;
                
                long maxCarry = maxMove * w[i];
                
                long goldFromCity = Math.min(g[i], maxCarry);
                long silverFromCity = Math.min(s[i], maxCarry);
                long totalFromCity = Math.min(g[i] + s[i], maxCarry);
                
                totalGold += goldFromCity;
                totalSilver += silverFromCity;
                totalWeight += totalFromCity;
            }
            
            if (a <= totalGold && b <= totalSilver && (a + b) <= totalWeight) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}
