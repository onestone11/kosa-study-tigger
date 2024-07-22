import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];

        String[] numbers = br.readLine().split(" ");

        for(int k=0; k<n; k++) dp[k] = 1;

        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                int num1 = Integer.parseInt(numbers[i]);
                int num2 = Integer.parseInt(numbers[j]);

                if(num2 < num1) dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }
        
        int answer = dp[0];
        for(int m=1; m<n; m++) {
            if(answer < dp[m]) answer = dp[m];
        }

        System.out.println(answer);
    }
}
