import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2502 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int D = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] dpA = new int[D+1];
        int[] dpB = new int[D+1];
        int A, B;

        dpA[1] = 1;
        dpA[2] = 0;
        dpA[3] = 1;
        
        dpB[1] = 0;
        dpB[2] = 1;
        dpB[3] = 1;

        for(int i=4; i<=D; i++) {
            dpA[i] = dpB[i-1];
            dpB[i] = dpA[i-1] + dpB[i-1];
        }

        int cnt = 1;

        while(true) {
            if((K - (dpA[D] * cnt)) % dpB[D] == 0) {
                A = cnt;
                B = (K - (dpA[D] * cnt)) / dpB[D];
                break;
            }
            cnt++;
        }

        System.out.println(A);
        System.out.println(B);
    }
}
