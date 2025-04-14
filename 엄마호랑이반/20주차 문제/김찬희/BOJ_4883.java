import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = 1;

        while(true) {
            int n = Integer.parseInt(br.readLine());

            if(n == 0) break;

            int[][] dp = new int[n][3];
            
            for(int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<3; j++) {
                    dp[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 가장 윗 행 초기화
            dp[0][0] = Integer.MAX_VALUE;       // 어차피 왼쪽으로는 갈 수 없기 때문에 가장 큰 값 설정
            // dp[0][1]은 그대로 유지 (출발점)
            dp[0][2] += dp[0][1];               // (0,0) -> (0,1)의 경로를 통해 (0,2)로 도달할 수 있기 때문

            for(int row=1; row<n; row++) {
                dp[row][0] += Math.min(dp[row-1][0], dp[row-1][1]);
                dp[row][1] += Math.min(dp[row][0], Math.min(dp[row-1][0], Math.min(dp[row-1][1], dp[row-1][2])));
                dp[row][2] += Math.min(dp[row][1], Math.min(dp[row-1][1], dp[row-1][2]));
            }
            
            System.out.println(test_case + ". " + dp[n-1][1]);
            test_case++;
        }
    }
}
