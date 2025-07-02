import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		
		int maxVal = 0;
		for(int i = 1; i < n+1; i++) {
			// 업무 수행 가능한 경우 중 최댓값
			// 1. 어제 업무를 마쳐서 오늘부터 새로 일 시작하기
			// 2. 오늘 기존 일을 수행하기 
      
			dp[i] = Math.max(dp[i-1], dp[i]);    // 오늘 값 셋팅
						
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int d = Integer.parseInt(st.nextToken());	// 상담 소요 시간
			int v = Integer.parseInt(st.nextToken());	// 가치
			
			int deadLine = i + d - 1;	// 당일을 포함한 마감일
			
			if(deadLine <= n) {
				dp[deadLine] = Math.max(dp[i-1] + v, dp[deadLine]);    // 마감일 셋팅 (실제 이익을 얻는 날)
				maxVal = Math.max(dp[deadLine], maxVal);
			}
			
		}
		
		System.out.print(maxVal);
	}
}
