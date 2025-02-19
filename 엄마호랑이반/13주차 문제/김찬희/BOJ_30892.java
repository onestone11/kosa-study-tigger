import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static long eatShark(int[] sharks, long t, int k) {
        if(sharks[0] >= t) return t;

        Stack<Integer> stack = new Stack<>();
        int cnt = 0;

        for(int i=0; i<sharks.length; i++) {
            if(cnt == k) return t;

            if(sharks[i] >= t) {
                // 5 3 5
                // 4 10 16 20 24
                if(stack.empty()) return t;
                t += stack.pop();
                cnt++;
                i--;
            } else {
                stack.push(sharks[i]);
            }
        }
        
        while(cnt < k) {
            t += stack.pop();
            cnt++;
        }

        return t;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 상어 마릿수
        int k = Integer.parseInt(st.nextToken());   // 먹을 수 있는 상어의 최대 마릿수
        long t = Long.parseLong(st.nextToken());    // 샼의 최초 크기

        st = new StringTokenizer(br.readLine());
        int[] sharks = new int[n];

        for(int i=0; i<n; i++) {
            sharks[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sharks);
        System.out.println(eatShark(sharks, t, k));
    }
}
