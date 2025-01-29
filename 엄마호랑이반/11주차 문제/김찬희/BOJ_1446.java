import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][3];
        int[] dp = new int[d+1];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int j=0; j<=d; j++) dp[j] = j;

        for(int k=1; k<=d; k++) {
            dp[k] = Math.min(dp[k], dp[k-1] + 1);

            for(int m=0; m<n; m++) {
                if(k == arr[m][1]) {
                    dp[k] = Math.min(dp[k], dp[arr[m][0]] + arr[m][2]);
                }
            }
        }
        System.out.println(dp[d]);
    }
}
