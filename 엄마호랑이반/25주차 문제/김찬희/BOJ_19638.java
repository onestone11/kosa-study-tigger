import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());       // 거인 인구 수
        int h = Integer.parseInt(st.nextToken());       // 센티의 키
        int t = Integer.parseInt(st.nextToken());       // 마법의 뿅망치 횟수 제한
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<n; i++) {
            int height = Integer.parseInt(br.readLine());
            queue.add(height);
        }

        int cnt = 0;
        for(int j=0; j<t; j++) {
            if(queue.peek() == 1 || queue.peek() < h) break;

            queue.add(queue.poll()/2);
            cnt++;
        }

        if (queue.peek() < h) {
            System.out.println("YES");
            System.out.println(cnt);
        } else {
            System.out.println("NO");
            System.out.println(queue.peek());
        }
    }
}
