import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }

    public static int getDistance(int a, int b, int c, int d) {
        return (a - c) * (a - c) + (b - d) * (b - d);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int stop_x, stop_y;
        int now_x, now_y;
        int dx, dy;

        stop_x = Integer.parseInt(st.nextToken());
        stop_y = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        now_x = Integer.parseInt(st.nextToken());
        now_y = Integer.parseInt(st.nextToken());
        dx = Integer.parseInt(st.nextToken());
        dy = Integer.parseInt(st.nextToken());

        // dx, dy 최대공약수 구하기
        int temp = 0;
        if(dx < dy) temp = gcd(dx, dy);
        else temp = gcd(dy, dx);

        dx /= temp;
        dy /= temp;
        
        int answer_x = now_x;
        int answer_y = now_y;
        double minDistance = getDistance(stop_x, stop_y, now_x, now_y);
        
        while(true) {
            now_x += dx;
            now_y += dy;

            int d = getDistance(stop_x, stop_y, now_x, now_y);

            // 최소 거리보다 커진다는 것은 앞으로 쭉 더 멀어질 것이기 때문에 종료
            if(minDistance <= d) break;

            minDistance = d;
            answer_x = now_x;
            answer_y = now_y;
        }
        System.out.println(answer_x + " " + answer_y);
    }
}
