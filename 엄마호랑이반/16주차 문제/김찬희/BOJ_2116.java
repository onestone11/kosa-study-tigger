import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] numbers;
    public static int[] pairs = {5, 3, 4, 1, 2, 0};

    public static int findMaxNum(int k, int m) {
        int maxNum = 0;

        for(int p=0; p<6; p++) {
            if(p == m || p == pairs[m]) continue;
                        
            maxNum = Math.max(maxNum, numbers[k][p]);
        }
        return maxNum;
    }

    public static int calculate(int target, int n) {
        int answer = 0;

        for(int k=1; k<n; k++) {
            for(int m=0; m<6; m++) {
                if(numbers[k][m] == target) {
                    target = numbers[k][pairs[m]];

                    answer += findMaxNum(k, m);
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        numbers = new int[n][6];
        int answer = 0;

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<6; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int idx=0; idx<6; idx++) {
            int temp = Math.max(calculate(numbers[0][pairs[idx]], n), calculate(numbers[0][idx], n)) + findMaxNum(0, idx);
            answer = Math.max(answer, temp);
        }

        System.out.println(answer);
    }
}
