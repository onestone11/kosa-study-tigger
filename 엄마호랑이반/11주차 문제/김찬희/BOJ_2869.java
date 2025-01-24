import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());       // 올라갈 수 있는 길이
        int B = Integer.parseInt(st.nextToken());       // 미끄러지는 길이
        int V = Integer.parseInt(st.nextToken());       // 목표 나무 높이
        int answer = 0;

        if((V-B) % (A-B) == 0) answer = (V-B) / (A-B);
        else answer = (V-B) / (A-B) + 1;
        
        System.out.println(answer);
    }
}
