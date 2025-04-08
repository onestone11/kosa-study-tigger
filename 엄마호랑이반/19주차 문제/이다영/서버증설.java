import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int cnt = 0;
        int[] servers = new int[24];
        for (int t = 0; t < 24; t++) {
            int player = players[t];
            int server = servers[t];
            
            if (player < m || player < (server*m) || (server*m <= player && player < (server+1)*m)) {
                continue;
            }
            
            int x = (player - (server*m)) / m;
            cnt += x;
            for (int i = 0; i < k; i++) {
                if (t+i > 23) break;
                servers[t + i] += x;
            }
        }
        return cnt;
    }
}
