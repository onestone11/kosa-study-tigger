import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wines = new int[n+1];
        int[] dp = new int[n+1];
      
        for(int i=1; i<=n; i++) wines[i] = Integer.parseInt(br.readLine());
        
        dp[1] = wines[1];
        if(n > 1) dp[2] = wines[1] + wines[2];
        
        for(int j=3; j<=n; j++) dp[j] = Math.max(dp[j-1], Math.max(dp[j-2] + wines[j], dp[j-3] + wines[j-1] + wines[j]));
        
        System.out.println(dp[n]);
    }
}
