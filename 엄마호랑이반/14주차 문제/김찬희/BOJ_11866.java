import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for(int i=1; i<N+1; i++) queue.offer(i);

        int cnt = 1;
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            if(cnt == K) {
                sb.append(temp);
                sb.append(", ");
                cnt = 0;
            } else {
                queue.offer(temp);
            }

            cnt++;
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append(">");
        System.out.println(sb.toString());
    }
}
