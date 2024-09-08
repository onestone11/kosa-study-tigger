import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603 {
    public static boolean isVisited[];
    public static int[] numbers;
    public static int k;
    public static int[] arr;
    public static StringBuilder sb;

    public static void lotto(int start, int index) {
        // 종료 조건
        if(index == 6) {
            for(int num : numbers) sb.append(num).append(" ");

            sb.append("\n");
            return;
        }

        for(int i=start; i<k; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                numbers[index] = arr[i];
                lotto(i, index+1);
                isVisited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0) break;

            isVisited = new boolean[k];
            arr = new int[k];
            numbers = new int[6];

            for(int i=0; i<k; i++) arr[i] = Integer.parseInt(st.nextToken());

            lotto(0, 0);
            System.out.println(sb);
        }
    }
}